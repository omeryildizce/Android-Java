package com.omeryildizce.webservis4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.omeryildizce.webservis4.adapters.BilgiAdapter;
import com.omeryildizce.webservis4.models.Bilgi;
import com.omeryildizce.webservis4.restApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgi> list;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();
    }

    private void tanimla() {
        listView = findViewById(R.id.listview);
    }

    private void istek() {
        list = new ArrayList<>();
        Call<List<Bilgi>> call = ManagerAll.getInstance().getirCall();
        call.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    BilgiAdapter bilgiAdapter = new BilgiAdapter(list, MainActivity.this);
                    listView.setAdapter(bilgiAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}