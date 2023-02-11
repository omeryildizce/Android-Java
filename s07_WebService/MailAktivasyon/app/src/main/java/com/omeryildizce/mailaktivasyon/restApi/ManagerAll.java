package com.omeryildizce.mailaktivasyon.restApi;

import com.omeryildizce.mailaktivasyon.models.Results;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static final ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<Results> giris(String kullaniciadi, String sifre, String emailadres){
        return getRestApiClient().kontrol(kullaniciadi, sifre, emailadres);
    }

    public Call<Results> aktifEt(String mail, String code ){
        return getRestApiClient().aktifEt(mail, code);
    }

}