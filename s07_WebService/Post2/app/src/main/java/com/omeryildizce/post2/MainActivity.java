package com.omeryildizce.post2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.omeryildizce.post2.models.Sonuc;
import com.omeryildizce.post2.restApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText ad, soyad;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        ekle();
    }

    private void tanimla() {
        ad = findViewById(R.id.ad);
        soyad = findViewById(R.id.soyad);
        button = findViewById(R.id.button);
    }

    public void ekle() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ad.getText().toString().equals("") && !soyad.getText().toString().equals("")) {
                    istek(ad.getText().toString(), soyad.getText().toString());
                    ad.setText("");
                    soyad.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Boş Alanları Doldurunuz!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void istek(String ad, String soyad) {
        Call<Sonuc> x = ManagerAll.getInstance().ekle(ad, soyad);
        x.enqueue(new Callback<Sonuc>() {
            @Override
            public void onResponse(Call<Sonuc> call, Response<Sonuc> response) {
                if (response.body().getResult().equals("true")) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Sonuc> call, Throwable t) {

            }
        });
    }

}