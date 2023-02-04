package com.omeryildizce.realmdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        realmTanimla();
        tabloyaEkle();
        goster();
    }

    private void realmTanimla() {
        realm = Realm.getDefaultInstance();
    }

    public void tabloyaEkle(){
        realm.beginTransaction();
        KisilerTablosu kisilerTablosu = realm.createObject(KisilerTablosu.class);
        kisilerTablosu.setIsim("ali");
        kisilerTablosu.setSoyisim("YILDIZ");
        kisilerTablosu.setMaas(12_500);
        kisilerTablosu.setYas(23);
        realm.commitTransaction();
    }

    public void goster(){
        realm.beginTransaction();
        RealmResults<KisilerTablosu> sonuc = realm.where(KisilerTablosu.class).findAll();
        for (KisilerTablosu k : sonuc){
            Log.i("Çıktı", k.toString());

        }
        realm.commitTransaction();
    }
}