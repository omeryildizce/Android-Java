package com.omeryildizce.dbjson.models;

public class Kullanici {
    private String isim;
    private String soyisim;
    private String id;

    @Override
    public String toString() {
        return "Kullanici{" +
                "isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", id='" + id + '\'' +
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
