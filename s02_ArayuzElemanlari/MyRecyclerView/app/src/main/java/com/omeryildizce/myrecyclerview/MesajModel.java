package com.omeryildizce.myrecyclerview;

public class MesajModel {
    private String name;
    private String message;
    private int ResimId;

    public MesajModel(String name, String message, int resimId) {
        this.name = name;
        this.message = message;
        ResimId = resimId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResimId() {
        return ResimId;
    }

    public void setResimId(int resimId) {
        ResimId = resimId;
    }
}
