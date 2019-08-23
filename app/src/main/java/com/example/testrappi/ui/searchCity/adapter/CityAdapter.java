package com.example.testrappi.ui.searchCity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testrappi.R;
import com.example.testrappi.models.city.City;
import com.example.testrappi.utils.ImagenUtils;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityAdapterViewHolder>
                            implements View.OnClickListener{

    private Context context;
    private List<City> cities;
    public View.OnClickListener listener;

    public CityAdapter(Context context, List<City> cities) {
        this.context = context;
        this.cities = cities;
    }

    public class CityAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCountry, txtCity;
        private ImageView imageFlag;

        public CityAdapterViewHolder(View itemView) {
            super(itemView);
            txtCountry = (TextView) itemView.findViewById(R.id.txtCountry);
            txtCity = (TextView) itemView.findViewById(R.id.txtCity);
            imageFlag = (ImageView) itemView.findViewById(R.id.imgFlag);
        }
    }

    @Override
    public CityAdapter.CityAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_city, parent, false);
        itemView.setOnClickListener(this);
        return new CityAdapter.CityAdapterViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CityAdapter.CityAdapterViewHolder holder, final int position) {
        final City city = cities.get(position);

        TextView txtCountry = holder.txtCountry;
        TextView txtCity = holder.txtCity;
        ImageView imageFlag = holder.imageFlag;

        txtCity.setText(city.getName());
        txtCountry.setText(city.getCountry_name());
        ImagenUtils.loadImage(context, city.getCountry_flag_url(), imageFlag);

    }

    @Override
    public int getItemCount() {
        return cities.size();
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

