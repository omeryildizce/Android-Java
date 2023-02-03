package com.omeryildizce.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        tiklama();

    }

    private void tiklama() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gecisYap();
            }
        });
    }

    public void tanimla()
    {
        button = findViewById(R.id.button);
    }
    private void gecisYap() {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}