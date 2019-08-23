package com.example.testrappi.ui.listRestaurantOfCity.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testrappi.R;
import com.example.testrappi.models.collection.Collection;
import com.example.testrappi.models.collection.ObjectCollection;
import com.example.testrappi.ui.restaurantofCollections.RestaurantOfCollectionsActivity;
import com.example.testrappi.utils.ImagenUtils;

import java.util.List;

public class CollectionAdapter extends BaseAdapter {

    private List<ObjectCollection> objectCollections;
    private Context context;
    private Integer city_id;

    public CollectionAdapter(Context context, List<ObjectCollection> objectCollections, Integer city_id){
        this.context = context;
        this.objectCollections = objectCollections;
        this.city_id = city_id;
    }

    @Override
    public int getCount() {
        return objectCollections.size();
    }

    @Override
    public ObjectCollection getItem(int position) {
        return objectCollections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_collection, viewGroup, false);
        }
        final Collection collection = objectCollections.get(position).getCollection();

        ImageView imageCollection = (ImageView) view.findViewById(R.id.image);
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);

        txtTitle.setText(collection.getTitle());
        ImagenUtils.loadImage(context, collection.getImage_url(), imageCollection);

        imageCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RestaurantOfCollectionsActivity.class);
                Bundle extras = new Bundle();
                extras.putString("collection_id", String.valueOf(collection.getCollection_id()));
                extras.putInt("city_id", city_id);
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });

        return view;
    }

}
