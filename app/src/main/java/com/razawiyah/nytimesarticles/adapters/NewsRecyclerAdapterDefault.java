package com.razawiyah.nytimesarticles.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.razawiyah.nytimesarticles.R;
import com.razawiyah.nytimesarticles.apis.ApiResponseDefault;
import com.razawiyah.nytimesarticles.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

public class NewsRecyclerAdapterDefault extends RecyclerView.Adapter<NewsRecyclerAdapterDefault.NewsViewHolder> {

    List<ApiResponseDefault.Article> articleList;
    public NewsRecyclerAdapterDefault(List<ApiResponseDefault.Article> articleList){
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
        ApiResponseDefault.Article article = articleList.get(position);
        holder.titleTV.setText(article.getTitle());
        String formattedDate = DateUtils.formatPublishedDate(article.getPublished_date());
        holder.dateTV.setText(formattedDate);

        holder.abstractTV.setText(article.getAbstractText());

        if (article.getMedia() != null && !article.getMedia().isEmpty()) {
            ApiResponseDefault.Article.Media media = article.getMedia().get(0);
            if (media.getUrl() != null && !media.getUrl().isEmpty()) {

                Picasso.get().load(media.getUrl())
                        .error(R.drawable.icon_iamge_error)
                        .placeholder(R.drawable.icon_iamge_error)
                        .into(holder.articleImg);

            }
        }

    }

    public void updateData(List<ApiResponseDefault.Article> data){
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
