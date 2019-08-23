package com.example.testrappi.ui.RestaurantDetails;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testrappi.R;
import com.example.testrappi.models.restaurant.Restaurant;
import com.example.testrappi.models.review.ObjectReview;
import com.example.testrappi.models.review.Review;
import com.example.testrappi.ui.RestaurantDetails.adapter.ReviewAdapter;
import com.example.testrappi.ui.listRestaurantOfCity.ListRestaurantActivity;
import com.example.testrappi.ui.listRestaurantOfCity.ListRestaurantContract;
import com.example.testrappi.ui.listRestaurantOfCity.adapter.RestaurantAdapter;
import com.example.testrappi.utils.ImagenUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailsActivity extends AppCompatActivity implements OnMapReadyCallback, RestaurantDetailsContract.View {

    @BindView(R.id.carouselView)
    CarouselView carouselView;

    @BindView(R.id.txtName)
    TextView txtName;

    @BindView(R.id.txtCuisines)
    TextView txtCousines;

    @BindView(R.id.txtTimings)
    TextView txtTimings;

    @BindView(R.id.txtPhone)
    TextView txtPhone;

    @BindView(R.id.txtAverageCostForTwo)
    TextView txtAverageCostForTwo;

    @BindView(R.id.txtAddress)
    TextView txtAddress;

    @BindView(R.id.txtCity)
    TextView txtCity;

    @BindView(R.id.mapView)
    MapView mapView;

    @BindView(R.id.listReview)
    RecyclerView listReview;

    private Restaurant restaurant;
    protected ProgressDialog progressDialog;
    RestaurantDetailsContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        progressDialog = new ProgressDialog(this);
        mPresenter = new RestaurantDetailsPresenter(this, this);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            restaurant = (Restaurant) extras.getSerializable("restaurant");
            setRestaurantInView(restaurant);
            mPresenter.getReview(Integer.valueOf(restaurant.getId()));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMinZoomPreference(12);
        googleMap.setIndoorEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        LatLng ny = new LatLng(restaurant.getLocation().getLatitude(), restaurant.getLocation().getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(ny);
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ny));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void setRestaurantInView(Restaurant restaurant){
        txtName.setText(restaurant.getName());
        txtCousines.setText(getString(R.string.label_cousine)+" "+restaurant.getCuisines());
        txtTimings.setText(getString(R.string.label_schedule)+" "+restaurant.getTimings());
        txtPhone.setText(getString(R.string.label_phone)+" "+restaurant.getPhone_numbers());
        txtAverageCostForTwo.setText(getString(R.string.label_average)+" "+restaurant.getAverage_cost_for_two() +" "+ restaurant.getCurrency());
        txtAddress.setText(getString(R.string.label_address)+" "+restaurant.getLocation().getAddress());
        txtCity.setText(getString(R.string.labelCity)+" "+restaurant.getLocation().getCity());
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                ImagenUtils.loadImage(RestaurantDetailsActivity.this, restaurant.getFeatured_image(), imageView);
            }
        });
        carouselView.setPageCount(2);
    }

    @Override
    public void viewReview(List<ObjectReview> reviews) {
        loadReview(reviews);
    }

    private void loadReview(List<ObjectReview> reviews){
        LinearLayoutManager manager = new LinearLayoutManager(RestaurantDetailsActivity.this, RecyclerView.VERTICAL, false);
        listReview.setLayoutManager(manager);
        ReviewAdapter reviewAdapter = new ReviewAdapter(this, reviews);
        listReview.setAdapter(reviewAdapter);
    }

    @Override
    public void showErrorMessage(String message) {
        progressDialog.dismiss();
        Toast.makeText(RestaurantDetailsActivity.this, message, Toast.LENGTH_LONG).show();
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
