package com.omeryildizce.urunlerilisteleme.restApi;

import com.omeryildizce.urunlerilisteleme.models.Urunler;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static final ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<List<Urunler>> getirBilgileri(){
        return getRestApiClient().bilgiGetir();
    }
}