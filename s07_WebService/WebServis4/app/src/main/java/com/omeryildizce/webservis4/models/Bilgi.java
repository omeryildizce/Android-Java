package com.omeryildizce.webservis4.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bilgi{
    @Expose
    @SerializedName("body")
    private String body;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("postId")
    private int postId;

    public Bilgi(String body, String email, String name, int id, int postId) {
        this.body = body;
        this.email = email;
        this.name = name;
        this.id = id;
        this.postId = postId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
