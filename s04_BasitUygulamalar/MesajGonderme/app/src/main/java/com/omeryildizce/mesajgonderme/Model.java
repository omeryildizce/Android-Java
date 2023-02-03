package com.omeryildizce.mesajgonderme;

public class Model {
    private String isim;
    private String telefon;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Model(String isim, String telefon) {
        this.isim = isim;
        this.telefon = telefon;
    }
}
