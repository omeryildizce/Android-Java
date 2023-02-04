package com.omeryildizce.realmdatabase;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class KisilerTablosu extends RealmObject {
    private String isim;
    private String soyisim;
    private int maas;
    private int yas;

    @Override
    public String toString() {
        return "KisilerTablosu{" +
                "isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", maas=" + maas +
                ", yas=" + yas +
                '}';
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
