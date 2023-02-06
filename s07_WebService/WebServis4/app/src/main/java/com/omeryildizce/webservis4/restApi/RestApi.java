package com.omeryildizce.webservis4.restApi;

import com.omeryildizce.webservis4.models.Bilgi;
import com.omeryildizce.webservis4.models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("comments/")
    Call<List<Bilgi>> getir();

    @GET("comments") Call<List<Result>> getirResult(@Query("postId") String postId, @Query("id") String id);



}
