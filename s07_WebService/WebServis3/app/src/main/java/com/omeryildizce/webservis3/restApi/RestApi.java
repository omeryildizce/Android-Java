package com.omeryildizce.webservis3.restApi;

import com.omeryildizce.webservis3.models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("photos/")
    Call<List<Bilgi>> getir();
}
