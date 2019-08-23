package com.example.testrappi.ui.RestaurantDetails.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testrappi.R;
import com.example.testrappi.models.review.ObjectReview;
import com.example.testrappi.models.review.Review;
import com.example.testrappi.utils.ImagenUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewAdapterViewHolder> {

    private Context context;
    private List<ObjectReview> reviews;
    public View.OnClickListener listener;

    public ReviewAdapter(Context context, List<ObjectReview> reviews) {
        this.context = context;
        this.reviews = reviews;
    }

    public class ReviewAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName, txtReview, txtDate;
        private CircleImageView imgProfile;
        private RatingBar ratingBar;

        public ReviewAdapterViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtReview = (TextView) itemView.findViewById(R.id.txtReview);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            imgProfile = (CircleImageView) itemView.findViewById(R.id.imgProfile);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }

    @Override
    public ReviewAdapter.ReviewAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_review, parent, false);
        return new ReviewAdapter.ReviewAdapterViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ReviewAdapter.ReviewAdapterViewHolder holder, final int position) {
        final Review review = reviews.get(position).getReview();

        TextView txtName = holder.txtName;
        TextView txtReview = holder.txtReview;
        TextView txtDate = holder.txtDate;
        CircleImageView imgProfile = holder.imgProfile;
        RatingBar ratingBar = holder.ratingBar;

        ImagenUtils.loadImage(context, review.getUser().getProfile_image(), imgProfile);
        txtName.setText(review.getUser().getName());
        txtReview.setText(review.getReview_text());
        txtDate.setText(review.getReview_time_friendly());
        ratingBar.setRating(review.getRating());

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

}
