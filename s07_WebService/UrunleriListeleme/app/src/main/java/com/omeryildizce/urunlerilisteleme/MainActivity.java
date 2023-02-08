package com.omeryildizce.urunlerilisteleme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.omeryildizce.urunlerilisteleme.adapters.UrunAdapter;
import com.omeryildizce.urunlerilisteleme.models.Urunler;
import com.omeryildizce.urunlerilisteleme.restApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView urunListView;
    List<Urunler> urunlerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istekAt();
    }

    private void tanimla() {
        urunListView = findViewById(R.id.urunListView);
    }


    public void istekAt(){
        Call<List<Urunler>> istek = ManagerAll.getInstance().getirBilgileri();
        istek.enqueue(new Callback<List<Urunler>>() {
            @Override
            public void onResponse(Call<List<Urunler>> call, Response<List<Urunler>> response) {
                if (response.isSuccessful()){
                    urunlerList = new ArrayList<>();
                    urunlerList = response.body();
                    UrunAdapter adapter = new UrunAdapter(urunlerList, MainActivity.this);
                    urunListView.setAdapter(adapter);
                }
                Log.i("Mesaj", "onResponse: "+ response.body());
            }

            @Override
            public void onFailure(Call<List<Urunler>> call, Throwable t) {
                Log.i("Mesaj", "onResponse: failure"+t.getMessage());


            }
        });
    }
}