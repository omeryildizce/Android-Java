package com.omeryildizce.mylistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<MesajModel> list;
    MesajAdapter mesajAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        listeDoldur();

    }

    private void listeDoldur() {
        list = new ArrayList<>();
        MesajModel m1 = new MesajModel("Merhaba ben Niloya", "Niloya", R.drawable.resim1);
        MesajModel m2 = new MesajModel("Merhaba ben Murat", "Murat", R.drawable.resim2);
        MesajModel m3 = new MesajModel("Merhaba ben Ali", "Ali", R.drawable.resim3);
        MesajModel m4 = new MesajModel("Merhaba ben Ömer", "Ömer", R.drawable.resim4);
        MesajModel m5 = new MesajModel("Merhaba ben Ayşe", "Ayşe", R.drawable.resim5);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);

        mesajAdapter = new MesajAdapter(list, this);
        listView.setAdapter(mesajAdapter);
    }

    private void tanimla() {
        listView = findViewById(R.id.listview);
        
    }
}