package com.omeryildizce.urunlerilisteleme.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urunler {
    @Expose
    @SerializedName("urunresimi")
    private String urunresimi;
    @Expose
    @SerializedName("urunfiyati")
    private String urunfiyati;
    @Expose
    @SerializedName("urunadi")
    private String urunadi;
    @Expose
    @SerializedName("id")
    private String id;

    public String getUrunresimi() {
        return urunresimi;
    }

    public void setUrunresimi(String urunresimi) {
        this.urunresimi = urunresimi;
    }

    public String getUrunfiyati() {
        return urunfiyati;
    }

    public void setUrunfiyati(String urunfiyati) {
        this.urunfiyati = urunfiyati;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Urunler{" +
                "urunresimi='" + urunresimi + '\'' +
                ", urunfiyati='" + urunfiyati + '\'' +
                ", urunadi='" + urunadi + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
