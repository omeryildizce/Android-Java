package com.omeryildizce.post2.restApi;

import com.omeryildizce.post2.models.Sonuc;

import retrofit2.Call;

public class ManagerAll extends  BaseManager{
    private static ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }
    public Call<Sonuc> ekle(String ad, String soyad){
        Call<Sonuc> x = getRestApi().addUser(ad, soyad);
        return x;
    }
}
