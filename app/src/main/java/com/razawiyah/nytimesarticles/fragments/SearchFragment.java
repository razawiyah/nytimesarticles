package com.razawiyah.nytimesarticles.fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.razawiyah.nytimesarticles.R;
import com.razawiyah.nytimesarticles.adapters.NewsRecyclerAdapter;
import com.razawiyah.nytimesarticles.adapters.NewsRecyclerAdapterDefault;
import com.razawiyah.nytimesarticles.apis.ApiClient;
import com.razawiyah.nytimesarticles.apis.ApiResponseDefault;
import com.razawiyah.nytimesarticles.apis.ApiServices;
import com.razawiyah.nytimesarticles.utils.PopupUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    ApiServices apiServices;
    private static final String API_KEY = "Lm61K8L0sLAMcPCHDYXGFzjAnyf0H6ZI";
    RecyclerView recyclerView;
    List<ApiResponseDefault.Article> articleList = new ArrayList<>();
    NewsRecyclerAdapterDefault newsRecyclerAdapter;
    LinearProgressIndicator linearProgressIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        //recycler view part
        recyclerView = view.findViewById(R.id.recyclerViewS);
        linearProgressIndicator = view.findViewById(R.id.progressIndicatorS);

        setRecyclerView();
        setNews();

        return view;
    }

    private void setNews(){
        changeInProgress(true);
        apiServices = ApiClient.getClient().create(ApiServices.class);
        Call<ApiResponseDefault> call = apiServices.getDefaultResult(API_KEY);

        call.enqueue(new Callback<ApiResponseDefault>() {
            @Override
            public void onResponse(Call<ApiResponseDefault> call, Response<ApiResponseDefault> response) {
                if(response.isSuccessful()){
                    ApiResponseDefault mostViewed = response.body();

                    if(mostViewed != null){
                        if (mostViewed.getResults() != null){
                            for (ApiResponseDefault.Article article: mostViewed.getResults()){
//                                Log.d(TAG, "title: " + article.getTitle());
                                articleList = mostViewed.getResults();
                                newsRecyclerAdapter.updateData(articleList);
                                newsRecyclerAdapter.notifyDataSetChanged();
                            }
                            Log.d(TAG, "Most Viewed Done");
                            changeInProgress(false);


                        }else {
                            PopupUtils.showAlert(getActivity(), "No Result!", "Data Not Fetched!");
                        }

                    }else {
                        PopupUtils.showAlert(getActivity(), "No Body!", "Data Not Fetched!");
                    }
                }else {
                    PopupUtils.showAlert(getActivity(), "No Response!", "Problem with API!");
                }
            }

            @Override
            public void onFailure(Call<ApiResponseDefault> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsRecyclerAdapter = new NewsRecyclerAdapterDefault(articleList);
        recyclerView.setAdapter(newsRecyclerAdapter);
    }

    public void changeInProgress(boolean show){
        if (show){
            linearProgressIndicator.setVisibility(View.VISIBLE);
        } else {
            linearProgressIndicator.setVisibility(View.INVISIBLE);
        }
    }
}