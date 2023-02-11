package com.omeryildizce.mailaktivasyon.restApi;


import com.omeryildizce.mailaktivasyon.models.Results;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    @FormUrlEncoded
    @POST("proje/mailgonder.php")
    Call<Results> kontrol(@Field("kullaniciadi") String kullaniciadi, @Field("sifre")String sifre, @Field("mailadres")String mailadres);

    @GET("proje/aktifet.php")
    Call<Results> aktifEt(@Query("mail") String mail, @Query("code") String code);

}