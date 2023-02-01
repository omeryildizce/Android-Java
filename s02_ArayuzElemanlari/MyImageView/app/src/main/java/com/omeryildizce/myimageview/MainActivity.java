package com.omeryildizce.myimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        tikla();

    }

    private void tikla() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * 4) + 1;
                degistir(random);
            }
        });
    }

    private void degistir(int random) {
        switch (random) {
            case 1:
                imageView.setImageResource(R.drawable.su);
                break;
            case 2:
                imageView.setImageResource(R.drawable.toprak);
                break;
            case 3:
                imageView.setImageResource(R.drawable.ates);
                break;
            default:
                imageView.setImageResource(R.drawable.hava);
                break;
        }
    }

    private void tanimla() {
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.btn);

    }
}