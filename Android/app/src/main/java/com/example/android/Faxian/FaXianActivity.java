package com.example.android.Faxian;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.R;
import com.example.android.Wode.WoDeActivity;
import com.example.android.cloudvileage.cloudvillegActivity;
import com.example.android.cloudvileage.recy.icon;
import com.google.android.material.navigation.NavigationView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaXianActivity extends AppCompatActivity implements OnBannerListener {
    //轮播
    private Banner banner;
   // private ArrayList<String> list_path;
    private ArrayList<Integer> list_path = new ArrayList<>();
    private ArrayList<String> list_title;

    //推荐歌单GridView
    private RecyclerView ry;
    private GridLayoutManager layoutManager;
    private RecyclerAdapter mAdapter;
    private static List<Music> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faxian);
        //轮播图初始化
        initView();

        //recycelview
        ry = (RecyclerView) findViewById(R.id.faxian_ry);
        layoutManager = new GridLayoutManager(this, 6);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mList.get(position).type;
                if (type == Music.TYPE.TYPE_GRID_THREE) {
                    return 2;
                } else if (type == Music.TYPE.TYPE_GRID_TWO) {
                    return 3;
                } else if (type == Music.TYPE.TYPE_LIST) {
                    return 6;
                } else if (type == Music.TYPE.TYPE_TITLE) {
                    return 6;
                }
                return 0;
            }
        });
        ry.setLayoutManager(layoutManager);
        ry.addItemDecoration(new SpacesItemDecoration(2));

        // 填充数据
        mAdapter = new RecyclerAdapter(this, mList);
//        mAdapter.setOnItemClickListener((OnItemClickListener) this);
        ry.setAdapter(mAdapter);

        //toolbar顶部跳转设置
        TextView mine_title = findViewById(R.id.mine_title);
        mine_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaXianActivity.this, WoDeActivity.class);
                startActivity(intent);
            }
        });
        TextView cloudvellage = findViewById(R.id.cloudvell_title);
        cloudvellage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaXianActivity.this, cloudvillegActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initView() {
        banner = (Banner) findViewById(R.id.banner_faxian);
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        //获取本地的图片
        for (int position =1; position <5; position++) {
            //这里面的a  代表drawable里面自己放的本地图片
            list_path.add(getResId("banner" + position, R.drawable.class));
        }
        list_title.add("张韶涵世界巡回演唱会");
        list_title.add("TaylorSwift");
        list_title.add("Kris新歌");
        list_title.add("陈奕迅-明报");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();
    }
    /**
     * 通过文件名获取资源id 例子：getResId("icon", R.drawable.class);
     */
    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第"+position+"张轮播图");
    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);

        }
    }
    /**
     * 模拟本地数据
     */
    static {
        mList = new ArrayList<>();

        //板块一标题
        for (int i = 0; i < 1; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_TITLE;
            music.imageId = R.drawable.dzq;
            music.title = "[华语速爆新歌]最新华语音乐推荐";
            mList.add(music);
        }

        for (int i = 0; i < 6; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_GRID_THREE;
            if(i==0){
                music.imageId = R.drawable.p1_1;
                music.title = "JJ林俊杰新歌速递";
            }
            else if(i==1){
                music.imageId = R.drawable.p1_2;
                music.title = "前方是迷途";
            }
            else if(i==2){
                music.imageId = R.drawable.p1_3;
                music.title = "快来周董这儿听歌啦";
            }
            else if(i==3){
                music.imageId = R.drawable.p1_4;
                music.title = "你看看我";
            }
            else if(i==4){
                music.imageId = R.drawable.p1_5;
                music.title = "我看看你";
            }
            else if(i==5){
                music.imageId = R.drawable.p1_6;
                music.title = "找不到出口";
            }
            mList.add(music);
        }


        //板块二标题
        for (int i = 0; i < 1; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_TITLE;
            music.imageId = R.drawable.ljj;
            music.title = "回忆杀系列";
            mList.add(music);
        }

        for (int i = 0; i < 4; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_GRID_TWO;
            if(i==0){
                music.imageId = R.drawable.p2_1;
                music.title = "经典英语歌曲";
            }
            else if(i==1){
                music.imageId = R.drawable.p2_2;
                music.title = "八度空间";
            }
            else if(i==2){
                music.imageId = R.drawable.p2_3;
                music.title = "潘玮柏";
            }
            else if(i==3){
                music.imageId = R.drawable.p2_4;
                music.title = "Phoenix";
            }
            mList.add(music);
        }

        //板块三标题
        for (int i = 0; i < 1; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_TITLE;
            music.imageId = R.drawable.yl;
            music.title = "海贼王经典曲目";
            mList.add(music);
        }

        for (int i = 0; i < 3; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_LIST;
            if(i==0){
                music.imageId = R.drawable.p3_1;
                music.title = "黄金岛";
            }
            else if(i==1){
                music.imageId = R.drawable.p3_2;
                music.title = "和之国";
            }
            else if(i==2){
                music.imageId = R.drawable.p3_3;
                music.title = "我要成为海贼王";
            }
            mList.add(music);
        }

        //板块四标题
        for (int i = 0; i < 1; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_TITLE;
            music.imageId = R.drawable.ljj;
            music.title = "许嵩专场，你听过吗";
            mList.add(music);
        }

        for (int i = 0; i < 9; i++) {
            Music music = new Music();
            music.type = Music.TYPE.TYPE_GRID_THREE;
            if(i==0){
                music.imageId = R.drawable.p4_1;
                music.title = "不如吃茶去";
            }
            else if(i==1){
                music.imageId = R.drawable.p4_2;
                music.title = "幻听";
            }
            else if(i==2){
                music.imageId = R.drawable.p4_3;
                music.title = "青年晚报";
            }
            else if(i==3){
                music.imageId = R.drawable.p4_4;
                music.title = "雅俗共赏";
            }
            else if(i==4){
                music.imageId = R.drawable.p4_5;
                music.title = "断桥残雪";
            }
            else if(i==5){
                music.imageId = R.drawable.p4_6;
                music.title = "庐州月";
            }
            else if(i==6){
                music.imageId = R.drawable.p4_7;
                music.title = "千古";
            }
            else if(i==7){
                music.imageId = R.drawable.p4_8;
                music.title = "七夕";
            }
            else if(i==8){
                music.imageId = R.drawable.p4_9;
                music.title = "玫瑰花的葬礼";
            }
            mList.add(music);
        }


    }
    //点击事件，暂时用不到

    public void OnItemClick(int position) {
        String title = mList.get(position).title;
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }
}
