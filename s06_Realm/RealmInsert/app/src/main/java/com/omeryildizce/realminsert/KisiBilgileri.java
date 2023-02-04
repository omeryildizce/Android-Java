package com.omeryildizce.realminsert;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class KisiBilgileri extends RealmObject {
    private String kullanici;
    private String isim;
    private String cinsiyet;
    private String sifre;

    @Override
    public String toString() {
        return "KisiBilgileri{" +
                "kullanici='" + kullanici + '\'' +
                ", isim='" + isim + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", sifre='" + sifre + '\'' +
                '}';
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
