package com.jaicob.movieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaicob.movieapp.R;
import com.jaicob.movieapp.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jaicob on 7/19/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);

        // Check if existing view is being reused
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);

        // Clear out prev image
        ivImage.setImageResource(0);

        // Get text views
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        // Populate text
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        // Load movie images
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);

        return convertView;
    }
}
