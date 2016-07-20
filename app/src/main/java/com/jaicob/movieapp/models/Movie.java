package com.jaicob.movieapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jaicob on 7/19/16.
 */
public class Movie {

    String posterPath;
    String originalTitle;
    String overview;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for(int i = 0; i < array.length(); i++) {
            Movie m = null;
            try {
                m = new Movie(array.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            results.add(m);
        }
        return results;
    }
}
