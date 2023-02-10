package com.omeryildizce.paremetreliservisyazma.restApi;
import com.omeryildizce.paremetreliservisyazma.models.Uye;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("proje/girisyap.php")
    Call<List<Uye>> addUser(@Field("username") String username, @Field("password")String password);
}