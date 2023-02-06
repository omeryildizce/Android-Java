package com.omeryildizce.webservis2.restApi;

import com.omeryildizce.webservis2.models.Bilgi;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static ManagerAll ourGetInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourGetInstance;
    }
    public Call<List<Bilgi>> getirBilgi()
    {
        Call<List<Bilgi>> x = getRestApiClient().getir();
        return x;
    }
}

