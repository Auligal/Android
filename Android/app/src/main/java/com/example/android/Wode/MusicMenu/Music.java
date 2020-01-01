package com.example.android.Wode.MusicMenu;

public class Music {
    private int alltime;
    private int image;
    private String name;

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

    public Music(int alltime, int image, String name) {
        this.alltime = alltime;
        this.image = image;
        this.name = name;
    }
}
