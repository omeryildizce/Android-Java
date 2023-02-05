package com.omeryildizce.webservice.restApi;

import com.omeryildizce.webservice.models.Bilgiler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/posts/")
    Call<List<Bilgiler>> bilgiGetir();
}
