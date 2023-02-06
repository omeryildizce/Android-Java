package com.omeryildizce.webservis4.restApi;

import com.omeryildizce.webservis4.models.Bilgi;
import com.omeryildizce.webservis4.models.Result;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<List<Bilgi>> getirCall() {
        Call<List<Bilgi>> x = getRestApi().getir();
        return x;
    }

    public Call<List<Result>> managerGetResult(String postId , String id) {
        Call<List<Result>> x = getRestApi().getirResult(postId, id);
        return x;
    }

}
