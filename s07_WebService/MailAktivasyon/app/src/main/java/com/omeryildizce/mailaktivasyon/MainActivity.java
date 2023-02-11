package com.omeryildizce.mailaktivasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.omeryildizce.mailaktivasyon.models.Results;
import com.omeryildizce.mailaktivasyon.restApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText kullaniciAdiText, kullaniciSifreEditText, kullaniciMailEditText;
    Button ekleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();

    }

    public void tanimla() {
        kullaniciAdiText = findViewById(R.id.kullaniciAdiEditText);
        kullaniciSifreEditText = findViewById(R.id.sifreEditText);
        kullaniciMailEditText = findViewById(R.id.kullaniciMailEditText);
        ekleButton = findViewById(R.id.ekleButton);
        ekleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istekAt();
            }
        });
    }

    public void istekAt() {
        String kullaniciAdi, kullaniciSifre, kullaniciMail;
        kullaniciAdi = kullaniciAdiText.getText().toString();
        kullaniciSifre = kullaniciSifreEditText.getText().toString();
        kullaniciMail = kullaniciMailEditText.getText().toString();
        if (!kullaniciAdi.isEmpty() && !kullaniciSifre.isEmpty() && !kullaniciMail.isEmpty()) {
            Call<Results> istek = ManagerAll.getInstance().giris(kullaniciAdi, kullaniciSifre, kullaniciMail);
            istek.enqueue(new Callback<Results>() {
                @Override
                public void onResponse(Call<Results> call, Response<Results> response) {
                    if (response.body().result) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("mailadresi", kullaniciMail);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<Results> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Kayıtlısınız", Toast.LENGTH_SHORT).show();

                }
            });
        } else {
            Toast.makeText(this, "Bilgiler eksik", Toast.LENGTH_SHORT).show();
        }

    }
}