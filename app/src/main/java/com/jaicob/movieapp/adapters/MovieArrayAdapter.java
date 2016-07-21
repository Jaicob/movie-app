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

    private static class ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivImage;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);
        ViewHolder viewHolder;

        // Check if existing view is being reused
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Clear out prev image
        viewHolder.ivImage.setImageResource(0);

        // Populate text
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        // Load movie images
        Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivImage);

        return convertView;
    }
}
