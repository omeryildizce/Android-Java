package com.omeryildizce.paremetreliservisyazma.models;

public class UyeBilgileri {
    private String uyeid;
    private String uyeismi;
    private String uyeyasi;
    private String uyeokul;
    private String uyeresim;
    private String uyemailadres;

    @Override
    public String toString() {
        return "UyeBilgileri{" +
                "uyeid='" + uyeid + '\'' +
                ", uyeismi='" + uyeismi + '\'' +
                ", uyeyasi='" + uyeyasi + '\'' +
                ", uyeokul='" + uyeokul + '\'' +
                ", uyeresim='" + uyeresim + '\'' +
                ", uyemailadres='" + uyemailadres + '\'' +
                '}';
    }

    public String getUyeid() {
        return uyeid;
    }

    public void setUyeid(String uyeid) {
        this.uyeid = uyeid;
    }

    public String getUyeismi() {
        return uyeismi;
    }

    public void setUyeismi(String uyeismi) {
        this.uyeismi = uyeismi;
    }

    public String getUyeyasi() {
        return uyeyasi;
    }

    public void setUyeyasi(String uyeyasi) {
        this.uyeyasi = uyeyasi;
    }

    public String getUyeokul() {
        return uyeokul;
    }

    public void setUyeokul(String uyeokul) {
        this.uyeokul = uyeokul;
    }

    public String getUyeresim() {
        return uyeresim;
    }

    public void setUyeresim(String uyeresim) {
        this.uyeresim = uyeresim;
    }

    public String getUyemailadres() {
        return uyemailadres;
    }

    public void setUyemailadres(String uyemailadres) {
        this.uyemailadres = uyemailadres;
    }
}
