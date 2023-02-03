package com.omeryildizce.myspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String[] istanbulIlce = {"Ümraniye", "Kadıköy", "Ataşehir", "Avcılar","Arnavutköy", "Şişli"};
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        adapterOlustur();
        spinnerAdapterEkle();
        bilgiVer();
    }

    private void bilgiVer() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.format("%s", spinner.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void spinnerAdapterEkle() {
        spinner.setAdapter(arrayAdapter);
    }

    private void adapterOlustur() {
        arrayAdapter = new ArrayAdapter(this,  com.google.android.material.R.layout.support_simple_spinner_dropdown_item, istanbulIlce);
    }

    private void tanimla() {
        spinner = findViewById(R.id.spinner);
    }
    

}