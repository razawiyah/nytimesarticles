package com.razawiyah.nytimesarticles.apis;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("svc/mostpopular/v2/viewed/1.json")
    Call<ApiResponse> getMostViewed(
            @Query ("api-key") String apiKey
    );

    @GET("svc/mostpopular/v2/shared/1.json")
    Call<ApiResponse> getMostShared(
            @Query ("api-key") String apiKey
    );

    @GET("svc/mostpopular/v2/emailed/1.json")
    Call<ApiResponse> getMostEmailed(
            @Query ("api-key") String apiKey
    );

    @GET("svc/search/v2/articlesearch.json")
    Call<ApiResponseSearch> getSearchResult(
            @Query ("api-key") String apiKey,
            @Query ("q") String keyword

    );

    @GET("svc/topstories/v2/home.json")
    Call<ApiResponseDefault> getDefaultResult(
            @Query ("api-key") String apiKey
    );
}
