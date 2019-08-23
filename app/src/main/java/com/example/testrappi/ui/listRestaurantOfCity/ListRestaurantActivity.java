package com.example.testrappi.ui.listRestaurantOfCity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testrappi.R;
import com.example.testrappi.models.city.City;
import com.example.testrappi.models.collection.ObjectCollection;
import com.example.testrappi.models.restaurant.ObjectRestaurant;
import com.example.testrappi.ui.RestaurantDetails.RestaurantDetailsActivity;
import com.example.testrappi.ui.listRestaurantOfCity.adapter.CollectionAdapter;
import com.example.testrappi.ui.listRestaurantOfCity.adapter.RestaurantAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListRestaurantActivity extends AppCompatActivity implements ListRestaurantContract.View {

    @BindView(R.id.listRestaurant)
    RecyclerView listRestaurant;

    @BindView(R.id.gridCollection)
    GridView gridCollection;

    private Integer city_id;
    protected ProgressDialog progressDialog;
    ListRestaurantContract.Presenter mPresenter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(getString(R.string.label_restaurants));
        progressDialog = new ProgressDialog(this);
        mPresenter = new ListRestaurantPresenter(this, this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            City city = (City) extras.getSerializable("city");
            showProgressDialog(getString(R.string.searching));
            mPresenter.getRestaurants(city.getId());
            mPresenter.getCollections(city.getId());
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
        loadListCity(restaurants);
        progressDialog.dismiss();
    }

    public void loadListCity(List<ObjectRestaurant> restaurants) {
        LinearLayoutManager manager = new LinearLayoutManager(ListRestaurantActivity.this, RecyclerView.VERTICAL, false);
        listRestaurant.setLayoutManager(manager);
        RestaurantAdapter cityAdapter = new RestaurantAdapter(this, restaurants);
        cityAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListRestaurantActivity.this, RestaurantDetailsActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("restaurant", restaurants.get(listRestaurant.getChildAdapterPosition(v)).getRestaurant());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        listRestaurant.setAdapter(cityAdapter);
    }


    @Override
    public void viewCollections(List<ObjectCollection> collections) {
        CollectionAdapter adapter = new CollectionAdapter(ListRestaurantActivity.this, collections);
        gridCollection.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String message) {
        progressDialog.dismiss();
        Toast.makeText(ListRestaurantActivity.this, message, Toast.LENGTH_LONG).show();
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
}
