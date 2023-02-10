package com.omeryildizce.uploadserver.restapi;

import com.omeryildizce.uploadserver.models.Result;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }
    public Call<Result> gonder(String baslik, String resim){
        Call<Result> x = getRestApi().gonder(baslik, resim);
        return x;
    }
}

