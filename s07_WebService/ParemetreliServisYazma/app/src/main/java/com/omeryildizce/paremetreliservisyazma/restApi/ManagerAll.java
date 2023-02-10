package com.omeryildizce.paremetreliservisyazma.restApi;

import com.omeryildizce.paremetreliservisyazma.models.Uye;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static final ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<List<Uye>> ekle(String username, String password){
        return getRestApiClient().addUser(username,password);
    }
}