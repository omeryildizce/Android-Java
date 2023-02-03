package com.omeryildizce.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MesajModel> list;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        listeDoldur();

    }

    private void tanimla() {
      list = new ArrayList<>();
      recyclerView = findViewById(R.id.recyclerView);
      layoutManager = new LinearLayoutManager(this);
      recyclerView.setLayoutManager(layoutManager);
    }

    private void listeDoldur() {
        MesajModel m1 = new MesajModel("Fil","Merhaba ben bir filim", R.drawable.resim1);
        MesajModel m2 = new MesajModel("Aslan","Merhaba ben bir aslanım", R.drawable.resim2);
        MesajModel m3 = new MesajModel("Koyun","Merhaba ben bir koyunum", R.drawable.resim3);
        MesajModel m4 = new MesajModel("Sincap","Merhaba ben bir sincabım", R.drawable.resim4);
        MesajModel m5 = new MesajModel("Kedi","Merhaba ben bir kediyim", R.drawable.resim5);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        adapter = new Adapter(list, this);
        recyclerView.setAdapter(adapter);


    }
}