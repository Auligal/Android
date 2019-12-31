package com.example.android.Faxian;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.android.R;
import com.example.android.Wode.WoDeActivity;
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
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = { R.drawable.dzq, R.drawable.ys, R.drawable.ljj,
            R.drawable.zjl, R.drawable.yl, R.drawable.hzw};
    private String[] iconName = {
            "[华语速爆新歌]最新华语音乐推荐",
            "且随疾风前行，身后亦需留心",
            "回忆杀系列",
            "这是你的告白气球吗",
            "听了心情会变好的欢快古风小调",
            "海贼王经典曲目"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faxian);
        initView();
        gview = (GridView) findViewById(R.id.gridview_tjgd);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.item_tjgd, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);

        //toolbar顶部跳转设置
        TextView mine_title = findViewById(R.id.mine_title);
        mine_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaXianActivity.this, WoDeActivity.class);
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

//        list_path.add(R.drawable.banner1);
//        list_path.add(R.drawable.banner2);
//        list_path.add(R.drawable.banner3);
//        list_path.add(R.drawable.banner4);
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
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
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
     *
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

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

}
