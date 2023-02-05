package com.omeryildizce.webservice.restApi;

import com.omeryildizce.webservice.models.Bilgiler;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static final ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<List<Bilgiler>> getirBilgileri(){
        return getRestApiClient().bilgiGetir();
    }
}
