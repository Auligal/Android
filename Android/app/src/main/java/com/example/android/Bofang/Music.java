package com.example.android.Bofang;

public class Music {
    private int alltime;
    private int image;
    private String name;
    private String url;
    private String singer;
    private int changpian;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlltime() {
        return alltime;
    }

    public void setAlltime(int alltime) {
        this.alltime = alltime;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getChangpian() {
        return changpian;
    }

    public void setChangpian(int changpian) {
        this.changpian = changpian;
    }

    public Music(int alltime, int image, String name, String url, String singer, int changpian) {
        this.alltime = alltime;
        this.image = image;
        this.name = name;
        this.url = url;
        this.singer = singer;
        this.changpian = changpian;
    }
}
