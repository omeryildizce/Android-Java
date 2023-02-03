package com.omeryildizce.activityornekuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PersonActivity extends AppCompatActivity {
    TextView tvIsim, tvSoyisim, tvNumara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        tanimla();
        al();
    }

    private void al() {
        Intent intent = getIntent();
        tvIsim.setText(intent.getStringExtra("isim"));
        tvSoyisim.setText(intent.getStringExtra("soyisim"));
        tvNumara.setText(intent.getStringExtra("numara"));
    }

    private void tanimla() {
        tvIsim = findViewById(R.id.isim1);
        tvSoyisim = findViewById(R.id.soyisim1);
        tvNumara = findViewById(R.id.numara1);
    }

}