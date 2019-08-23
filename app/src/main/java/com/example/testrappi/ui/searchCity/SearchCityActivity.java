package com.example.testrappi.ui.searchCity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testrappi.R;
import com.example.testrappi.models.city.City;
import com.example.testrappi.ui.listRestaurantOfCity.ListRestaurantActivity;
import com.example.testrappi.ui.searchCity.adapter.CityAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchCityActivity extends AppCompatActivity implements SearchCityContract.View {

    @BindView(R.id.btnSearch)
    ImageButton btnSearch;

    @BindView(R.id.edtSearch)
    EditText edtSearch;

    @BindView(R.id.listCities)
    RecyclerView listCities;

    protected ProgressDialog progressDialog;
    SearchCityContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Buscar Ciudades");
        progressDialog = new ProgressDialog(this);
        mPresenter = new SearchCityPresenter(this, this);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtSearch.getText().toString().equals("") ){
                    showProgressDialog(getString(R.string.searching));
                    mPresenter.getCities(edtSearch.getText().toString());
                } else {
                    Toast.makeText(SearchCityActivity.this, "el campo ciudad no puede ser vacio", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    public void viewCities(List<City> cities) {
        loadListCity(cities);
        progressDialog.dismiss();

    }

    @Override
    public void showErrorMessage(String message) {
        progressDialog.dismiss();
        Toast.makeText(SearchCityActivity.this, message, Toast.LENGTH_LONG).show();

    }

    public void loadListCity(List<City> cities) {
        LinearLayoutManager manager = new LinearLayoutManager(SearchCityActivity.this, RecyclerView.VERTICAL, false);
        listCities.setLayoutManager(manager);
        CityAdapter cityAdapter = new CityAdapter(this, cities);
        cityAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Brayan", cities.get(listCities.getChildAdapterPosition(v)).getId()+"");
                Intent intent = new Intent(SearchCityActivity.this, ListRestaurantActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("city", cities.get(listCities.getChildAdapterPosition(v)));
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        listCities.setAdapter(cityAdapter);
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
