package com.omeryildizce.webservis2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;

import com.omeryildizce.webservis2.adapters.BilgiAdapter;
import com.omeryildizce.webservis2.models.Bilgi;
import com.omeryildizce.webservis2.restApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgi> bilgiList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();

    }

    private void tanimla() {
        listView = findViewById(R.id.listView);
    }

    public void istek() {
        bilgiList = new ArrayList<>();
        Call<List<Bilgi>> listCall = ManagerAll.getInstance().getirBilgi();
        listCall.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()) {
                    bilgiList = response.body();
                    BilgiAdapter bilgiAdapter = new BilgiAdapter(bilgiList, MainActivity.this);
                    listView.setAdapter(bilgiAdapter);
                    Log.i("Bilgi", "onResponse: "+bilgiList.size());

                }
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {
                    Log.i("Bilgi", "onResponse: failure");
            }
        });
    }
}