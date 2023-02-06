package com.omeryildizce.webservis2.restApi;

import com.omeryildizce.webservis2.models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("todos")
    Call<List<Bilgi>> getir();

}
