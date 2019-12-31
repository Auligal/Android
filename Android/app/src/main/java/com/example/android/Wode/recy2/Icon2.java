package com.example.android.Wode.recy2;
public class Icon2 {
    private String name;
    private int imageId;
    private String num;

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Icon2(String name, int imageId,String num) {
        this.name = name;
        this.imageId = imageId;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}