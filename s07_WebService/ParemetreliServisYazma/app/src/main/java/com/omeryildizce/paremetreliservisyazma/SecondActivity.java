package com.omeryildizce.paremetreliservisyazma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.omeryildizce.paremetreliservisyazma.models.UyeBilgileri;
import com.omeryildizce.paremetreliservisyazma.restApi.BaseUrl;
import com.omeryildizce.paremetreliservisyazma.restApi.ManagerAll;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    String id;
    TextView uyeOkul, uyeMailAdres, uyeIsim, uyeYas;
    ImageView uyeResim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tanimla();
        idAl();
        istekAt();
    }

    private void tanimla() {
        uyeOkul = findViewById(R.id.uyeOkul);
        uyeIsim = findViewById(R.id.uyeIsmi);
        uyeYas = findViewById(R.id.uyeYasi);
        uyeMailAdres = findViewById(R.id.uyemailAdres);
        uyeResim = findViewById(R.id.uyeResmi);
    }

    private void istekAt() {
        Call<UyeBilgileri> istek = ManagerAll.getInstance().getir(id);
        istek.enqueue(new Callback<UyeBilgileri>() {
            @Override
            public void onResponse(Call<UyeBilgileri> call, Response<UyeBilgileri> response) {
                uyeIsim.setText("Üye isminiz: "+response.body().getUyeismi());
                uyeMailAdres.setText("Mail Adresiniz: "+response.body().getUyemailadres());
                uyeYas.setText("Yaşınız: "+response.body().getUyeyasi());
                uyeOkul.setText("Okulunuz: "+response.body().getUyeokul());
                Picasso.get().load(BaseUrl.url+"/resimler/"+response.body().getUyeresim()).into(uyeResim);
            }

            @Override
            public void onFailure(Call<UyeBilgileri> call, Throwable t) {

            }
        });
    }

    public void idAl() {
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("idDeger");

    }
}