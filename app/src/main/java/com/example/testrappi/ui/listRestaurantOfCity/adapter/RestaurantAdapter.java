package com.example.testrappi.ui.listRestaurantOfCity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testrappi.R;
import com.example.testrappi.models.restaurant.ObjectRestaurant;
import com.example.testrappi.models.restaurant.Restaurant;
import com.example.testrappi.utils.ImagenUtils;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantAdapterViewHolder>
        implements View.OnClickListener {

    private Context context;
    private List<ObjectRestaurant> restaurants;
    public View.OnClickListener listener;

    public RestaurantAdapter(Context context, List<ObjectRestaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    public class RestaurantAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName, txtCousines, txtPhone;
        private ImageView imgRest;

        public RestaurantAdapterViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtCousines = (TextView) itemView.findViewById(R.id.txtCuisines);
            txtPhone = (TextView) itemView.findViewById(R.id.txtPhone);
            imgRest = (ImageView) itemView.findViewById(R.id.imgRest);
        }
    }

    @Override
    public RestaurantAdapter.RestaurantAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_restaurant, parent, false);
        itemView.setOnClickListener(this);
        return new RestaurantAdapter.RestaurantAdapterViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RestaurantAdapter.RestaurantAdapterViewHolder holder, final int position) {
        final Restaurant restaurant = restaurants.get(position).getRestaurant();

        TextView txtName = holder.txtName;
        TextView txtCousines = holder.txtCousines;
        TextView txtPhone = holder.txtPhone;
        ImageView imgRest = holder.imgRest;

        try {
            ImagenUtils.loadImage(context, restaurant.getThumb(), imgRest);
        } catch (Exception e){
            //ImagenUtils.loadImage(context, R.drawable.placeholder, imgRest);
            e.printStackTrace();
        }

        txtName.setText(restaurant.getName());
        if(restaurant.getCuisines().equals(null) || restaurant.getCuisines().equals("")) {
            txtCousines.setVisibility(View.GONE);
        } else {
            txtCousines.setText(restaurant.getCuisines());
        }
        if(restaurant.getPhone_numbers().equals(null) || restaurant.getPhone_numbers().equals("")) {
            txtPhone.setVisibility(View.GONE);
        } else {
            txtPhone.setText(restaurant.getPhone_numbers());
        }

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }
}
