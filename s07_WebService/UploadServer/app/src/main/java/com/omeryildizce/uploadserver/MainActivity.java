package com.omeryildizce.uploadserver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.omeryildizce.uploadserver.models.Result;
import com.omeryildizce.uploadserver.restapi.ManagerAll;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button resimSec, resimGonder;
    ImageView resim;
    EditText resimBaslik;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        islem();
    }

    public void tanimla() {
        resimSec = findViewById(R.id.resimSec);
        resimGonder = findViewById(R.id.resimGonder);
        resim = findViewById(R.id.resim);
        resimBaslik = findViewById(R.id.resimBaslik);
    }

    public void islem() {
        resimSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resimGoster();
            }
        });
        resimGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonder();
            }
        });
    }

    public void resimGoster() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 777);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 777 && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                resim.setImageBitmap(bitmap);
                resim.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void gonder(){
        String resimBasligi = resimBaslik.getText().toString();
        String imageToString = imageToString();
        Call<Result> x = ManagerAll.getInstance().gonder(resimBasligi,imageToString);
        x.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("TAG", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("TAG", "onFailure: ");
            }
        });
    }
    public String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byt = byteArrayOutputStream.toByteArray();
        String base64String = Base64.encodeToString(byt, Base64.DEFAULT);
        return base64String;
    }
}