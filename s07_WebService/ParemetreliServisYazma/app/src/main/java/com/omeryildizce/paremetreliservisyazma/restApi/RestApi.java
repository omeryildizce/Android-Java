package com.omeryildizce.paremetreliservisyazma.restApi;
import com.omeryildizce.paremetreliservisyazma.models.Uye;
import com.omeryildizce.paremetreliservisyazma.models.UyeBilgileri;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    @FormUrlEncoded
    @POST("proje/girisyap.php")
    Call<Uye> kontrol(@Field("username") String username, @Field("password")String password);


    @GET("proje/bilgiGetir.php")
    Call<UyeBilgileri> bilgiGetir(@Query("uyeid") String uyeid);
}