package com.omeryildizce.realmornek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    EditText buyukTansiyonEditText, kucukTansiyonEditText;
    BarChart barChart;
    Button ekleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        tanimla();
        ekle();
        goster();
        //sil();
    }

    private void tanimla() {
        buyukTansiyonEditText = findViewById(R.id.buyukTansiyon);
        kucukTansiyonEditText = findViewById(R.id.kuçukTansiyon);
        ekleButton = findViewById(R.id.ekleButton);
        barChart = findViewById(R.id.barChart);
    }

    public void ekle() {
        ekleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Tansiyon tansiyon = realm.createObject(Tansiyon.class);
                        tansiyon.setBuyukTansiyon(buyukTansiyonEditText.getText().toString());
                        tansiyon.setKucukTansiyon(kucukTansiyonEditText.getText().toString());

                    }
                });
                listele();
              goster();
            }
        });
    }

    public void listele() {
        RealmResults<Tansiyon> list = realm.where(Tansiyon.class).findAll();
        for (Tansiyon t : list) {

        }
    }

    public void goster() {
        RealmResults<Tansiyon> kisi = realm.where(Tansiyon.class).findAll();
        float buyukTansiyon =0.f;
        float kucukTansiyon = 0.f;
        for (int i = 0; i<kisi.size();i++) {

            buyukTansiyon += Float.parseFloat(kisi.get(i).getBuyukTansiyon());
            kucukTansiyon += Float.parseFloat(kisi.get(i).getKucukTansiyon());
        }
        ArrayList<BarEntry> arrayList = new ArrayList<>();
        arrayList.add(new BarEntry(buyukTansiyon, 0));
        arrayList.add(new BarEntry(kucukTansiyon, 0));
        BarDataSet barDataSet = new BarDataSet(arrayList, "Toplam Değer");
        ArrayList<String> sutunIsmi = new ArrayList<>();
        sutunIsmi.add("Büyük tansiyon");
        sutunIsmi.add("Küçük Tansiyon");
        BarData barData = new BarData(sutunIsmi, barDataSet);
        barChart.setData(barData);
        barChart.invalidate();
    }
    void sil(){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Tansiyon> kisi = realm.where(Tansiyon.class).findAll();
                kisi.deleteFromRealm(1);
            }
        });
    }
}