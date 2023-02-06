package com.omeryildizce.webservis2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bilgi {
    @Override
    public String toString() {
        return "Bilgi{" +
                "completed=" + completed +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                '}';
    }

    @Expose
    @SerializedName("completed")
    private boolean completed;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("userId")
    private int userId;

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}