package com.omeryildizce.realminsert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity {
    Realm realm;
    EditText kullaniciAdi, sifre, isim;
    Button btnKayitOl, btnGuncelle;
    RadioGroup cinsiyetGrup;
    RadioButton radioCinsiyet;
    ListView listView;
    int positionT = 0;
    String cinsiyetText, isimText, kullaniciText, sifreText;
    RealmResults<KisiBilgileri> list;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realmTanimla();
        tanimla();
        ekle();
        goster();
        pozisyonBul();

    }

    private void goster() {
        veriTabanindanListeGetir();
        if (list.size() > 0) {
            listView.setVisibility(View.VISIBLE);
            Adapter adapter = new Adapter(list, this);
            listView.setAdapter(adapter);
        } else {
            listView.setVisibility(View.INVISIBLE);
        }
    }

    public void realmTanimla() {
        realm = Realm.getDefaultInstance();

    }

    public void tanimla() {
        kullaniciAdi = findViewById(R.id.etKullanici);
        isim = findViewById(R.id.etIsim);
        sifre = findViewById(R.id.etSifre);
        cinsiyetGrup = findViewById(R.id.radioCinsiyet);
        btnKayitOl = findViewById(R.id.buttonKayitOl);
        listView = findViewById(R.id.lvKullanicilar);
        btnGuncelle = findViewById(R.id.buttonGuncelle);
    }

    public void ekle() {
        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bilgilerAl();
                yaz(kullaniciText, isimText, sifreText, cinsiyetText);
                goster();
                kullaniciAdi.setText("");
                isim.setText("");
                sifre.setText("");

            }
        });
        btnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veriTabanindanListeGetir();
                bilgilerAl();
                KisiBilgileri kisi = list.get(positionT);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        kisi.setCinsiyet(cinsiyetText);
                        kisi.setKullanici(kullaniciText);
                        kisi.setSifre(sifreText);
                        kisi.setIsim(isimText);
                    }
                });
                goster();

            }
        });
    }

    public void yaz(String kullaniciText, String isimText, String sifreText, String cinsiyetText) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                KisiBilgileri kisiBilgileri = realm.createObject(KisiBilgileri.class);
                kisiBilgileri.setCinsiyet(cinsiyetText);
                kisiBilgileri.setKullanici(kullaniciText);
                kisiBilgileri.setIsim(isimText);
                kisiBilgileri.setSifre(sifreText);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "Başarılı", Toast.LENGTH_SHORT).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(MainActivity.this, "Başarısız", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void pozisyonBul() {
        veriTabanindanListeGetir();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ac(position);
                kullaniciAdi.setText(list.get(position).getKullanici());
                sifre.setText(list.get(position).getSifre());
                isim.setText(list.get(position).getIsim());
                if (list.get(position).getCinsiyet().equals("Erkek")) {
                    ((RadioButton) cinsiyetGrup.getChildAt(0)).setChecked(true);
                } else {
                    ((RadioButton) cinsiyetGrup.getChildAt(1)).setChecked(true);
                }
                positionT = position;
            }
        });
    }

    public void sil(int position) {
        veriTabanindanListeGetir();
        realm.executeTransaction(realm -> {
            KisiBilgileri kisi = list.get(position);
            kisi.deleteFromRealm();
            goster();
            kullaniciAdi.setText("");
            isim.setText("");
            sifre.setText("");
        });
    }

    public void ac(int position) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_layout, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        Button evetButton = view.findViewById(R.id.btnEvet);
        Button hayirButton = view.findViewById(R.id.btnHayir);
        alert.setView(view);
        alert.setCancelable(false);
        AlertDialog dialog = alert.create();
        dialog.show();
        evetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sil(position);
                dialog.cancel();
            }
        });
        hayirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    public void bilgilerAl() {
        isimText = isim.getText().toString();
        kullaniciText = kullaniciAdi.getText().toString();
        sifreText = sifre.getText().toString();
        int id = cinsiyetGrup.getCheckedRadioButtonId();
        radioCinsiyet = findViewById(id);
        cinsiyetText = radioCinsiyet.getText().toString();
    }

    public void veriTabanindanListeGetir() {
        list = realm.where(KisiBilgileri.class).findAll();
    }
}