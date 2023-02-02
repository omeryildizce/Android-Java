package com.omeryildizce.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<KullaniciModel> kullaniciList;
    KullaniciListAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        listeDoldur();

    }

    public void listeDoldur() {
        kullaniciList = new ArrayList<>();
        KullaniciModel k1 = new KullaniciModel("Ömer", "33", "Yıldız", "Galatasaray");
        KullaniciModel k2 = new KullaniciModel("Ali", "43", "Yıldız", "Galatasaray");
        KullaniciModel k3 = new KullaniciModel("Başar", "23", "Koç", "Milan");
        KullaniciModel k4 = new KullaniciModel("Cansu", "53", "Başar", "Celtic");
        kullaniciList = new ArrayList<>();
        KullaniciModel k5 = new KullaniciModel("Ömer", "33", "Yıldız", "Galatasaray");
        KullaniciModel k6 = new KullaniciModel("Ali", "43", "Yıldız", "Galatasaray");
        KullaniciModel k7 = new KullaniciModel("Başar", "23", "Koç", "Milan");
        KullaniciModel k8 = new KullaniciModel("Cansu", "53", "Başar", "Celtic");
        kullaniciList.add(k1);
        kullaniciList.add(k2);
        kullaniciList.add(k3);
        kullaniciList.add(k4);  
        kullaniciList.add(k5);
        kullaniciList.add(k6);
        kullaniciList.add(k7);
        kullaniciList.add(k8);
        adapter = new KullaniciListAdapter(kullaniciList, this);
        listView.setAdapter(adapter);
    }
    void tanimla(){
        listView = findViewById(R.id.listView);
    }
}