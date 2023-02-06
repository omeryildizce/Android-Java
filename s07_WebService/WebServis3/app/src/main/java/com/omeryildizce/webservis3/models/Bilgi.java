package com.omeryildizce.webservis3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public   class Bilgi {

    @Expose
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;
    @Expose
    @SerializedName("url")
    private String url;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("albumId")
    private int albumId;

    @Override
    public String toString() {
        return "Bilgi{" +
                "thumbnailUrl='" + thumbnailUrl + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", albumId=" + albumId +
                '}';
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
