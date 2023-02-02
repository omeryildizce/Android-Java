package com.omeryildizce.myradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton resim1;
    RadioButton resim2;
    RadioButton resim3;
    RadioButton resim4;
    ImageView imageView;
    RadioGroup radioGroup;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        // isevVer();
        idAl();

    }

    private void idAl() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gelenId = radioGroup.getCheckedRadioButtonId();
                resimDegis(gelenId);

            }
        });
    }

    private void resimDegis(int gelenId) {
        if (gelenId == R.id.resim1) {
            imageView.setImageResource(R.drawable.resim1);
            Toast.makeText(MainActivity.this, resim1.getText(), Toast.LENGTH_SHORT).show();
        } else if (gelenId == R.id.resim2) {
            imageView.setImageResource(R.drawable.resim2);
            Toast.makeText(MainActivity.this, resim2.getText(), Toast.LENGTH_SHORT).show();
        } else if (gelenId == R.id.resim3) {
            imageView.setImageResource(R.drawable.resim3);
            Toast.makeText(MainActivity.this, resim3.getText(), Toast.LENGTH_SHORT).show();
        } else {
            imageView.setImageResource(R.drawable.resim4);
            Toast.makeText(MainActivity.this, resim4.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    private void isevVer() {
        resim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.resim1);
                Toast.makeText(MainActivity.this, resim1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        resim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.resim2);
                Toast.makeText(MainActivity.this, resim2.getText(), Toast.LENGTH_SHORT).show();

            }
        });
        resim3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.resim3);
                Toast.makeText(MainActivity.this, resim3.getText(), Toast.LENGTH_SHORT).show();

            }
        });
        resim4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.resim4);
                Toast.makeText(MainActivity.this, resim4.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tanimla() {
        resim1 = findViewById(R.id.resim1);
        resim2 = findViewById(R.id.resim2);
        resim3 = findViewById(R.id.resim3);
        resim4 = findViewById(R.id.resim4);
        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);
    }
}