package com.omeryildizce.activityarasiverigonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvIsim, tvSifre, tvCinsiyet;
    String isim, sifre, cinsiyet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tanimla();
        al();

    }

    private void tanimla() {
        tvIsim = findViewById(R.id.isim);
        tvSifre = findViewById(R.id.sifre);
        tvCinsiyet = findViewById(R.id.cinsiyet);
    }

    private void al() {
        Intent intent = getIntent();
        isim = intent.getStringExtra("kullaniciAdi");
        sifre = intent.getStringExtra("kullaniciSifre");
        cinsiyet = intent.getStringExtra("kullaniciCinsiyet");
        tvIsim.setText(isim);
        tvSifre.setText(sifre);
        tvCinsiyet.setText(cinsiyet);
    }
}