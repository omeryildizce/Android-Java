package com.omeryildizce.post2.restApi;

import com.omeryildizce.post2.models.Sonuc;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/sartliele.php")
    Call<Sonuc> addUser(@Field("ad") String ad, @Field("soyad") String soyad);
}
