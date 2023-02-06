package com.omeryildizce.picasso;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        resimCek();
    }

    private void resimCek() {
        Picasso.get().load("https://pladmin.mercedes-benz.com.tr/cdn/images/a_sedan_1.png").into(imageView);
    }

    private void tanimla() {
        imageView = findViewById(R.id.image);
    }
}