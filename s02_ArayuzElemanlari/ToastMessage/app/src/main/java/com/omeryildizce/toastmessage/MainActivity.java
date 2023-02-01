package com.omeryildizce.toastmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Merhaba", Toast.LENGTH_SHORT).show();
        tanimla();
        islevVer();
    }

    private void islevVer() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * 4 + 1);
                degistir(random);
                Toast.makeText(MainActivity.this, String.format("%d. resim", random), Toast.LENGTH_SHORT).show();
                
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
            case 4:
                imageView.setImageResource(R.drawable.hava);
                break;

        }
    }

    private void tanimla() {
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.button);
    }
}