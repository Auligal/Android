package com.example.android.Wode.MusicMenu;

public class Icon {
    private int num;
    private String name;
    private String singername;

    public Icon(int num, String name, String singername) {
        this.num = num;
        this.name = name;
        this.singername = singername;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }
}
