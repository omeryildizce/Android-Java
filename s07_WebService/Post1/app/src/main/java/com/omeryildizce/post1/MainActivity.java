package com.omeryildizce.post1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.omeryildizce.post1.models.Result;
import com.omeryildizce.post1.restApi.ManagerAll;

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
        add();
    }

    public void add() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isim = ad.getText().toString();
                String soyisim = soyad.getText().toString();
                if (!isim.equals("") && !soyisim.equals("")) {
                    istek(isim, soyisim);
                    deleteFromEditText();
                }
                else {
                    Toast.makeText(MainActivity.this, "Tüm alanları doldurun.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void deleteFromEditText() {
        ad.setText("");
        soyad.setText("");
    }

    private void tanimla() {
        ad = findViewById(R.id.ad);
        soyad = findViewById(R.id.soyad);
        button = findViewById(R.id.button);
    }

    public void istek(String ad, String soyad) {
        Call<Result> x = ManagerAll.getInstance().ekle(ad, soyad);
        x.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}