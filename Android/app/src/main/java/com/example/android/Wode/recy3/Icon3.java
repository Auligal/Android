package com.example.android.Wode.recy3;

public class Icon3 {
    int Image1;
    String str;
    String num;
    int Image2;

    public int getImage2() {
        return Image2;
    }

    public Icon3(int image1, String str, String num, int image2) {
        Image1 = image1;
        this.str = str;
        this.num = num;
        Image2 = image2;
    }

    public void setImage2(int image2) {
        Image2 = image2;
    }

    public int getImage1() {
        return Image1;
    }

    public void setImage1(int image1) {
        Image1 = image1;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
