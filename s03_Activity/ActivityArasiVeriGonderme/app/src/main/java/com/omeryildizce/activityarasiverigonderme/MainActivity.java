package com.omeryildizce.activityarasiverigonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText kullaniciAdi, kullaniciSifre;
    Button girisYap;
    RadioGroup radioCinsiyet;
    RadioButton radioButton;
    String isim, sifre, cinsiyet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        tiklaVeGec();
    }

    private void tiklaVeGec() {
        girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degerAl();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("kullaniciAdi", isim);
                intent.putExtra("kullaniciSifre", sifre);
                intent.putExtra("kullaniciCinsiyet", cinsiyet);
                startActivity(intent);
            }
        });
     }

    private void degerAl() {
        isim = kullaniciAdi.getText().toString();
        sifre = kullaniciSifre.getText().toString();
       radioButton = findViewById(radioCinsiyet.getCheckedRadioButtonId());
       cinsiyet = radioButton.getText().toString();

    }

    private void tanimla() {
        kullaniciAdi = findViewById(R.id.editTextKullanici);
        kullaniciSifre = findViewById(R.id.editTextSifre);
        girisYap = findViewById(R.id.buttonGiris);
        radioCinsiyet = findViewById(R.id.cinnsiyetGroup);

    }
}