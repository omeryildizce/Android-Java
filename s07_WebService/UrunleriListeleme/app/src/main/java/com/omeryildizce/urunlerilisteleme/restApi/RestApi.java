package com.omeryildizce.urunlerilisteleme.restApi;


import com.omeryildizce.urunlerilisteleme.models.Urunler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("proje/urunler.php")
    Call<List<Urunler>> bilgiGetir();
}