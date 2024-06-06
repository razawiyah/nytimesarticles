package com.razawiyah.nytimesarticles.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.razawiyah.nytimesarticles.FullArticle;
import com.razawiyah.nytimesarticles.R;
import com.razawiyah.nytimesarticles.apis.ApiResponseSearch;
import com.razawiyah.nytimesarticles.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsRecyclerAdapterSearch extends RecyclerView.Adapter<NewsRecyclerAdapterSearch.NewsViewHolder> {

    List<ApiResponseSearch.Article> articleList;
    public NewsRecyclerAdapterSearch(List<ApiResponseSearch.Article> articleList){
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
        ApiResponseSearch.Article article = articleList.get(position);
        holder.titleTV.setText(article.getSnippet());
        String formattedDate = DateUtils.formatPublishedDate(article.getPub_date());
        holder.dateTV.setText(formattedDate);

        holder.abstractTV.setText(article.getAbstractText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FullArticle.class);
                intent.putExtra("url", article.getUrl());
                v.getContext().startActivity(intent);
            }
        });

        if (article.getMultimedia() != null && !article.getMultimedia().isEmpty()) {
            ApiResponseSearch.Article.Media media = article.getMultimedia().get(0);
            if (media.getUrl() != null && !media.getUrl().isEmpty()) {

                Picasso.get().load("https://static01.nyt.com/"+media.getUrl())
                        .error(R.drawable.icon_iamge_error)
                        .placeholder(R.drawable.icon_iamge_error)
                        .into(holder.articleImg);

            }
        }

    }

    public void updateData(List<ApiResponseSearch.Article> data){
        articleList.clear();
        articleList.addAll(data);
    }

    @Override
    public int getItemCount() {

        return articleList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView titleTV, dateTV, abstractTV;
        ImageView articleImg;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.article_title);
            dateTV = itemView.findViewById(R.id.article_date);
            abstractTV = itemView.findViewById(R.id.article_abstract);
            articleImg = itemView.findViewById(R.id.article_image);

        }
    }
}
