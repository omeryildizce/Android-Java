package com.omeryildizce.mylistview;

public class KullaniciModel {
    String isim;
    String yas;
    String soyisim;
    String tuttuguTakim;

    public KullaniciModel(String isim, String yas, String soyisim, String tuttuguTakim) {
        this.isim = isim;
        this.yas = yas;
        this.soyisim = soyisim;
        this.tuttuguTakim = tuttuguTakim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTuttuguTakim() {
        return tuttuguTakim;
    }

    public void setTuttuguTakim(String tuttuguTakim) {
        this.tuttuguTakim = tuttuguTakim;
    }
}
