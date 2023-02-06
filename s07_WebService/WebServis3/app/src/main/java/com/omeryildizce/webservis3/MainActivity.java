package com.omeryildizce.webservis3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;

import com.omeryildizce.webservis3.adapters.BilgiAdapter;
import com.omeryildizce.webservis3.models.Bilgi;
import com.omeryildizce.webservis3.restApi.ManagerAll;

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
        listView = findViewById(R.id.listView);
    }

    public void istek() {
        list = new ArrayList<>();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Bilgiler Ekranı");
        progressDialog.setMessage("İçerik yükleniyor, Lütfen bekleyininiz...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Call<List<Bilgi>> servis = ManagerAll.getInstance().getirBilgi();
        servis.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    BilgiAdapter bilgiAdapter = new BilgiAdapter(list, MainActivity.this);
                    listView.setAdapter(bilgiAdapter);
                }
                Log.i("Response", "onResponse: success");
                progressDialog.cancel();
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {
                Log.i("Response", "onResponse: failure");

            }
        });
    }

}