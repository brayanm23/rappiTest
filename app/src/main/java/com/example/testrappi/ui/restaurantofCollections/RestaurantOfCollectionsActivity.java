package com.example.testrappi.ui.restaurantofCollections;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testrappi.R;
import com.example.testrappi.models.restaurant.ObjectRestaurant;
import com.example.testrappi.ui.RestaurantDetails.RestaurantDetailsActivity;
import com.example.testrappi.ui.listRestaurantOfCity.adapter.RestaurantAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantOfCollectionsActivity extends AppCompatActivity implements RestaurantOfCollectionsContract.View{

    @BindView(R.id.listRestaurant)
    RecyclerView listRestaurant;

    protected ProgressDialog progressDialog;
    RestaurantOfCollectionsContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(getString(R.string.label_restaurants));
        progressDialog = new ProgressDialog(this);
        mPresenter = new RestaurantOfCollectionsPresenter(this, this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Integer city_id = extras.getInt("city_id");
            String collection_id = extras.getString("collection_id");
            showProgressDialog(getString(R.string.searching));
            mPresenter.getRestaurants(city_id, collection_id);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void viewRestaurants(List<ObjectRestaurant> restaurants) {
        loadListRestaurants(restaurants);
        progressDialog.dismiss();
    }

    public void loadListRestaurants(List<ObjectRestaurant> restaurants) {
        LinearLayoutManager manager = new LinearLayoutManager(RestaurantOfCollectionsActivity.this, RecyclerView.VERTICAL, false);
        listRestaurant.setLayoutManager(manager);
        RestaurantAdapter cityAdapter = new RestaurantAdapter(this, restaurants);
        cityAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantOfCollectionsActivity.this, RestaurantDetailsActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("restaurant", restaurants.get(listRestaurant.getChildAdapterPosition(v)).getRestaurant());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        listRestaurant.setAdapter(cityAdapter);
    }

    public void showProgressDialog(String message) {
        if (progressDialog != null) {
            if(!isFinishing()) {
                if (!progressDialog.isShowing()) {
                    progressDialog.setMessage(message);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                } else {
                    progressDialog.setMessage(message);
                }
            }
        }
    }

    @Override
    public void showErrorMessage(String message) {
        progressDialog.dismiss();
        Toast.makeText(RestaurantOfCollectionsActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
