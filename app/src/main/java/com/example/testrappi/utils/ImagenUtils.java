package com.example.testrappi.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.example.testrappi.R;
import com.squareup.picasso.Picasso;

public class ImagenUtils {

    public static void loadImage(Context context, String photoUrl, ImageView view) {
        if (!photoUrl.isEmpty()) {
            Picasso.with(context).load(photoUrl).
                error(ContextCompat.getDrawable(context,R.drawable.placeholder)).
        into(view);
        }
    }

    public static void loadImage(Context context, int resource, ImageView view) {
        Picasso.with(context).load(resource).into(view);
    }
}
