package com.omeryildizce.mailaktivasyon;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity2 extends AppCompatActivity {
    EditText mail, code;
    Button aktifEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tanimla();

    }

    private void tanimla() {
        mail = findViewById(R.id.mailAdresiEditText);
        code = findViewById(R.id.codeEditText);
        aktifEt = findViewById(R.id.aktifEtButon);
        mail.setText(maiAdresiAl());
        aktifEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktif();
            }
        });
    }

    public String maiAdresiAl() {
        Bundle bundle = getIntent().getExtras();
        return bundle.getString("mailadresi");
    }

    public void aktif() {
        String usermail, mailcode;
        usermail = maiAdresiAl();
        mailcode = code.getText().toString();
        Call<Results> aktifEtResponse = ManagerAll.getInstance().aktifEt(usermail, mailcode);
        aktifEtResponse.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if (response.body().result)
                    Toast.makeText(MainActivity2.this, "True", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "False", Toast.LENGTH_SHORT).show();

            }
        });
    }
}