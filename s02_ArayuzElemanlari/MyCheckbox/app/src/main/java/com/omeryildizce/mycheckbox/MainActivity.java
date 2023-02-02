package com.omeryildizce.mycheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox phpC;
    CheckBox javaC;
    CheckBox jsC;
    CheckBox cSharpC;
    CheckBox pythonC;
    CheckBox kotlinC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        mesajVer();
    }

    private void mesajVer() {
        phpC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phpC.isChecked()){
                    Toast.makeText(MainActivity.this, String.format("%s seçildi.", phpC.getText()), Toast.LENGTH_SHORT).show();
                }
            }
        });
        javaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (javaC.isChecked()){
                    Toast.makeText(MainActivity.this, String.format("%s seçildi.", javaC.getText()), Toast.LENGTH_SHORT).show();
                }
            }
        });
        jsC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jsC.isChecked()){
                    Toast.makeText(MainActivity.this, String.format("%s seçildi.", jsC.getText()), Toast.LENGTH_SHORT).show();
                }
            }
        });
        cSharpC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cSharpC.isChecked()){
                    Toast.makeText(MainActivity.this, String.format("%s seçildi.", cSharpC.getText()), Toast.LENGTH_SHORT).show();
                }
            }
        });
        kotlinC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kotlinC.isChecked()){
                    Toast.makeText(MainActivity.this, String.format("%s seçildi.", kotlinC.getText()), Toast.LENGTH_SHORT).show();
                }
            }
        });
        pythonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pythonC.isChecked()){
                    Toast.makeText(MainActivity.this, String.format("%s seçildi.", pythonC.getText()), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void tanimla() {
    phpC = findViewById(R.id.php);
    javaC = findViewById(R.id.java);
    jsC = findViewById(R.id.javascript);
    cSharpC = findViewById(R.id.csharp);
    pythonC = findViewById(R.id.python);
    kotlinC = findViewById(R.id.kotlin);
    }
}