package com.omeryildizce.paremetreliservisyazma.restApi;

import com.omeryildizce.paremetreliservisyazma.models.Uye;
import com.omeryildizce.paremetreliservisyazma.models.UyeBilgileri;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static final ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<Uye> giris(String username, String password){
        return getRestApiClient().kontrol(username,password);
    }
    public Call<UyeBilgileri> getir(String uyeid){
        return getRestApiClient().bilgiGetir(uyeid);
    }
}