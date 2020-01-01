package com.example.android.Faxian;

public class Music {

    public int type;
    public String title;
    // 以后可加入Glide加载网络图片Url
    public int imageId;

    public interface TYPE {
        int TYPE_GRID_THREE = 0x01;
        int TYPE_GRID_TWO = 0x02;
        int TYPE_LIST = 0x03;
        int TYPE_TITLE = 0x04;
    }
}
