package com.omeryildizce.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.omeryildizce.webservice.adapters.AdapterBilgi;
import com.omeryildizce.webservice.models.Bilgiler;
import com.omeryildizce.webservice.restApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgiler> list;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        istek();
        tanimla();
    }

    private void tanimla() {
        listview = findViewById(R.id.listView);
    }

    public void istek() {
        list = new ArrayList<>();
        Call<List<Bilgiler>> bilgiList = ManagerAll.getInstance().getirBilgileri();
        bilgiList.enqueue(new Callback<List<Bilgiler>>() {
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    AdapterBilgi adapterBilgi = new AdapterBilgi(list, getApplicationContext());
                    listview.setAdapter(adapterBilgi);
                }
                Log.i("Response", "onResponse: success ");
            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {
                Log.i("Response", "onResponse: failed ");
            }
        });
    }
}