package com.omeryildizce.dbjson.restApi;

import com.omeryildizce.dbjson.models.Kullanici;
import com.omeryildizce.dbjson.models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {

    @GET("/listele.php")
    Call<List<Kullanici>> listele();

    @FormUrlEncoded
    @POST("/sil.php") Call<Result> sil(@Field("id") String id);

}
