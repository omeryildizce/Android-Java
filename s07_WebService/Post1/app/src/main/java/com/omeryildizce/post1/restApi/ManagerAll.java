package com.omeryildizce.post1.restApi;

import com.omeryildizce.post1.models.Result;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<Result> ekle(String ad, String soyad) {
        Call<Result> x = getRestApi().addUser(ad,soyad);
        return x;
    }
}
