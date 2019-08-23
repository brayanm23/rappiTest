package com.example.testrappi.ui.RestaurantDetails;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testrappi.R;
import com.example.testrappi.models.restaurant.Restaurant;
import com.example.testrappi.utils.ImagenUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

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

    @BindView(R.id.mapView)
    MapView mapView;

    private Restaurant restaurant;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        ButterKnife.bind(this);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            restaurant = (Restaurant) extras.getSerializable("restaurant");
            setRestaurantInView(restaurant);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        Log.d("Debug", restaurant.getLocation().getLatitude()+"");
        Log.d("Debug", restaurant.getLocation().getLongitude()+"");
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
        txtCousines.setText(restaurant.getCuisines());
        txtTimings.setText(restaurant.getTimings());
        txtPhone.setText(restaurant.getPhone_numbers());
        txtAverageCostForTwo.setText(restaurant.getAverage_cost_for_two() +" "+ restaurant.getCurrency());
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                ImagenUtils.loadImage(RestaurantDetailsActivity.this, restaurant.getFeatured_image(), imageView);
            }
        });
        carouselView.setPageCount(2);
    }
}
