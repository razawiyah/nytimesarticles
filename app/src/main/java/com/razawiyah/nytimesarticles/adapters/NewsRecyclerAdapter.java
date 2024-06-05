package com.razawiyah.nytimesarticles.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.razawiyah.nytimesarticles.R;
import com.razawiyah.nytimesarticles.apis.ApiResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder> {

    List<ApiResponse.Article> articleList;
    public NewsRecyclerAdapter(List<ApiResponse.Article> articleList){
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycler_content,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        ApiResponse.Article article = articleList.get(position);
        holder.titleTV.setText(article.getTitle());
        holder.abstractTV.setText(article.getAbstractText());

        if (article.getMedia() != null && !article.getMedia().isEmpty()) {
            ApiResponse.Article.Media media = article.getMedia().get(0);
            if (media.getMediaMetadata() != null && !media.getMediaMetadata().isEmpty()) {
                ApiResponse.Article.Media.MediaMetadata mediaMetadata = media.getMediaMetadata().get(0);
//                System.out.println("Image URL: " + mediaMetadata.getUrl());

                Picasso.get().load(mediaMetadata.getUrl())
                        .error(R.drawable.icon_iamge_error)
                        .placeholder(R.drawable.icon_iamge_error)
                        .into(holder.articleImg);

            }
        }

    }

    public void updateData(List<ApiResponse.Article> data){
        articleList.clear();
        articleList.addAll(data);
    }

    @Override
    public int getItemCount() {

        return articleList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView titleTV, abstractTV;
        ImageView articleImg;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.article_title);
            abstractTV = itemView.findViewById(R.id.article_abstract);
            articleImg = itemView.findViewById(R.id.article_image);

        }
    }
}
