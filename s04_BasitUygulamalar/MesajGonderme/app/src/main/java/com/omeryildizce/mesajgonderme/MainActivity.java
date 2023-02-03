package com.omeryildizce.mesajgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Model> list;
    ListView listView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeDoldur();
        tanimla();
    }

    private void tanimla() {
        listView = findViewById(R.id.mesajList);
        adapter = new Adapter(list, this);
        listView.setAdapter(adapter);
    }

    private void listeDoldur() {
        list = new ArrayList<>();
        Model m1 = new Model("Murat", "054000000000");
        Model m2 = new Model("Başar", "054000000000");
        Model m3 = new Model("Ege", "054000000000");
        Model m4 = new Model("Tamer", "054000000000");
        Model m5 = new Model("Kader", "054000000000");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
    }
}