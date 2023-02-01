package com.omeryildizce.arayuzelemanlari;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView;
    EditText editText;
    TextView tvFaktoriyelSonuc;
    Button buttonFaktoriyelHesapla;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        islevVer();
        faktoriyeliHesapla();
    }

    private void faktoriyeliHesapla() {
        buttonFaktoriyelHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int toplam = 1;
                String value = editText.getText().toString();
                int deger = 1;
                try {
                    deger = Integer.parseInt(value);
                } catch (Exception e) {
                    deger = 1;
                }

                for (int i = 1; i <= deger; i++) {

                        toplam *= i;

                }
                        tvFaktoriyelSonuc.setText(String.format("%d! = %d", deger, toplam));

            }
        });
    }

    private void tanimla() {
        btn = findViewById(R.id.button1);
        textView = findViewById(R.id.text1);
        editText = findViewById(R.id.editText1);
        tvFaktoriyelSonuc = findViewById(R.id.tvFaktoriyel);
        buttonFaktoriyelHesapla = findViewById(R.id.faktoriyHesapla);
    }

    private void islevVer() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(MessageFormat.format("Butuna {0} defa tıklandı", i++));
                Random random = new Random();
                int up = 255;
                int r = random.nextInt(up);
                int g = random.nextInt(up);
                int b = random.nextInt(up);
                textView.setTextColor(Color.rgb(r, g, b));
                r = random.nextInt(up);
                g = random.nextInt(up);
                b = random.nextInt(up);
                textView.setBackgroundColor(Color.rgb(r, g, b));

            }
        });

    }
}