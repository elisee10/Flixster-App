package com.example.flixster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;


public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    //So we can inflate a view, where it is being constructed from
    Context context;
    //List of movies adapter need to hold on too
    List<Movie> movies;

    //constructer
    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    //Usually inflates a layout from XML and will return it in the holder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    //Involved populating data into the item through the holder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the movie at the position
        Movie movie = movies.get(position);
        //bind the movie data into the video holder
        holder.bind((Movie) movies);


    }

    @Override
    //Involves the total count of the items in the list
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);



        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);

        }
    }
}