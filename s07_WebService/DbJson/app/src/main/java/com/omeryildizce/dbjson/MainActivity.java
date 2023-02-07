package com.omeryildizce.dbjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.omeryildizce.dbjson.adapters.KullaniciAdapter;
import com.omeryildizce.dbjson.models.Kullanici;
import com.omeryildizce.dbjson.restApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Kullanici> kullanici;
    KullaniciAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();
    }

    private void tanimla() {
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DialogClass dialogClass = new DialogClass(MainActivity.this, MainActivity.this);
                dialogClass.goster(kullanici.get(position).getId());
                adapter = new KullaniciAdapter(kullanici, MainActivity.this, MainActivity.this);
                listView.setAdapter(adapter);
            }
        });
    }

    private void istek() {
        Call<List<Kullanici>> x = ManagerAll.getInstance().goster();
        x.enqueue(new Callback<List<Kullanici>>() {
            @Override
            public void onResponse(Call<List<Kullanici>> call, Response<List<Kullanici>> response) {
                if (response.isSuccessful()) {
                    kullanici = new ArrayList<>();
                    adapter = new KullaniciAdapter(kullanici, MainActivity.this, MainActivity.this);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Kullanici>> call, Throwable t) {

            }
        });
    }
}