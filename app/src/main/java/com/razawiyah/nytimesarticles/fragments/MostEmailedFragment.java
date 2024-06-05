package com.razawiyah.nytimesarticles.fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.razawiyah.nytimesarticles.R;
import com.razawiyah.nytimesarticles.apis.ApiClient;
import com.razawiyah.nytimesarticles.apis.ApiResponse;
import com.razawiyah.nytimesarticles.apis.ApiServices;
import com.razawiyah.nytimesarticles.utils.PopupUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostEmailedFragment extends Fragment {

    ApiServices apiServices;
    private static final String API_KEY = "Lm61K8L0sLAMcPCHDYXGFzjAnyf0H6ZI";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_most_emailed, container, false);

        apiServices = ApiClient.getClient().create(ApiServices.class);
        Call<ApiResponse> call = apiServices.getMostEmailed(API_KEY);

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful()){
                    ApiResponse mostViewed = response.body();

                    if(mostViewed != null){
                        if (mostViewed.results != null){
                            for (ApiResponse.Article article: mostViewed.results){
                                Log.d(TAG, "title: " + article.title);
                            }
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
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });

        return view;    }
}