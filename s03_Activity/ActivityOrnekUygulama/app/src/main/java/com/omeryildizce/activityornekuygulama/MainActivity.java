package com.omeryildizce.activityornekuygulama;

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
        tanimla();
        listeOlustur();
        gec();
    }

    private void gec() {
        listView = findViewById(R.id.listView);
        adapter = new Adapter(list, this, this);
        listView.setAdapter(adapter);
    }

    private void tanimla() {
        list = new ArrayList<>();
    }

    private void listeOlustur() {
        Model m1 = new Model("Murat","Koç","0542");
        Model m2 = new Model("Ali","Koç","0544");
        Model m3 = new Model("Ali","Kaya","0544");
        Model m4 = new Model("Fatih","Kaya","0544");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

    }

}