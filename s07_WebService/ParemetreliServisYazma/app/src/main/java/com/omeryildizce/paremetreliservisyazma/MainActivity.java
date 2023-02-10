package com.omeryildizce.paremetreliservisyazma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.omeryildizce.paremetreliservisyazma.models.Uye;
import com.omeryildizce.paremetreliservisyazma.restApi.ManagerAll;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText  usernameEditText, passwordEditText;
    Button girisYapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istekAt();
    }

    private void tanimla() {
        usernameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        girisYapButton = findViewById(R.id.girisYapButton);
    }
    public void istekAt()
    {
        girisYapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                Call<Uye> istek = ManagerAll.getInstance().giris(username,password);
                istek.enqueue(new Callback<Uye>() {
                    @Override
                    public void onResponse(Call<Uye> call, Response<Uye> response) {
                        if (response.isSuccessful()){
                            String id = response.body().getId();
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            intent.putExtra("idDeger", id);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Uye> call, Throwable t) {

                    }
                });
            }
        });
    }

}