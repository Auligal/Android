package com.example.android.Wode;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.example.android.Faxian.FaXianActivity;
import com.example.android.R;
import com.example.android.Wode.recy1.Icon1;
import com.example.android.Wode.recy1.IconAdapter1;
import com.example.android.Wode.recy2.Icon2;
import com.example.android.Wode.recy2.IconAdapter2;
import com.example.android.Wode.recy3.Icon3;
import com.example.android.Wode.recy3.IconAdapter3;

import java.util.ArrayList;
import java.util.List;

public class WoDeActivity extends AppCompatActivity {
    List<Icon1> iconList1 = new ArrayList<Icon1>();
    List<Icon2> iconList2 = new ArrayList<Icon2>();
    List<Icon3> iconList3 = new ArrayList<Icon3>();
    List<Icon3> iconList4 = new ArrayList<Icon3>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wode);

        //顶部的toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
//                    case R.id.mine:
//                        Toast.makeText(WoDeActivity.this,"mine",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.find:
////                        Intent intent = new Intent(WoDeActivity.this,);
//                        Toast.makeText(WoDeActivity.this,"跳转发现页面",Toast.LENGTH_SHORT).show();
//                        break;
            }
            return false;
            }
        });
        ///初始化
        init();
        //获取RecyclerView的实例
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview_1);
        //创建一个layoutManager，这里使用LinearLayoutManager指定为线性，也就可以有ListView这样的效果
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //完成layoutManager设置
        recyclerView.setLayoutManager(layoutManager);
        //创建IconAdapter的实例同时将iconList传入其构造函数
        IconAdapter1 adapter = new IconAdapter1(iconList1);
        //完成adapter设置
        recyclerView.setAdapter(adapter);

        ///初始化
        init1();
//        //获取RecyclerView的实例
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycleview_2);
//        //创建一个layoutManager，这里使用LinearLayoutManager指定为线性，也就可以有ListView这样的效果
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
//        //完成layoutManager设置
        recyclerView2.setLayoutManager(layoutManager2);
//        //创建IconAdapter的实例同时将iconList传入其构造函数
        IconAdapter2 adapter2 = new IconAdapter2(iconList2);
//        //完成adapter设置
        recyclerView2.setAdapter(adapter2);
//我的界面的创建歌单recycleview设置适配器
        init2();
        RecyclerView recyclerView3 = (RecyclerView)findViewById(R.id.recycleview_3);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
        recyclerView3.setLayoutManager(layoutManager3);
        IconAdapter3 adapter3 = new IconAdapter3(iconList3);
        recyclerView3.setAdapter(adapter3);
//我的界面的收藏的歌单recycleview设置适配器
        RecyclerView recyclerView4 = (RecyclerView)findViewById(R.id.recycleview_4);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this);
        recyclerView4.setLayoutManager(layoutManager4);
        IconAdapter3 adapter4 = new IconAdapter3(iconList4);
        recyclerView4.setAdapter(adapter4);
//我的界面的底部音乐播放界面
//        TextView musicname = findViewById(R.id.bottomnavigationview_music_name);
//        musicname.setText("追梦赤子心");
//        TextView musicauthor = findViewById(R.id.bottomnavigationview_music_author);
//        musicauthor.setText("GALA");
        //toolbar顶部跳转设置
        TextView find_title = findViewById(R.id.find_title);
        find_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WoDeActivity.this, FaXianActivity.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
        for (int i=0;i<5;i++) {
            Icon1 a = new Icon1("QQ", R.drawable.a);
            iconList1.add(a);
            Icon1 b = new Icon1("Github", R.drawable.b);
            iconList1.add(b);
            Icon1 c = new Icon1("QQ", R.drawable.c);
            iconList1.add(c);
            Icon1 d = new Icon1("Github", R.drawable.d);
            iconList1.add(d);
            Icon1 e = new Icon1("QQ", R.drawable.e);
            iconList1.add(e);
            Icon1 f = new Icon1("Github", R.drawable.f);
            iconList1.add(f);
        }
    }
    private void init1(){
        Icon2 a = new Icon2("本地音乐", R.drawable.music,"(12)");
        iconList2.add(a);
        Icon2 b = new Icon2("最近播放", R.drawable.play,"(23)");
        iconList2.add(b);
        Icon2 c = new Icon2("下载管理", R.drawable.download,"(34)");
        iconList2.add(c);
        Icon2 d = new Icon2("我的电台", R.drawable.diantai,"(17)");
        iconList2.add(d);
        Icon2 e = new Icon2("我的收藏", R.drawable.star,"(10)");
        iconList2.add(e);
    }
    private void init2(){
        Icon3 a = new Icon3(R.drawable.recycle2,"我喜欢的音乐","11首",R.drawable.button_more);
        iconList3.add(a);
        Icon3 b = new Icon3(R.drawable.recycle2,"神探夏洛克","11首",R.drawable.button_more);
        iconList3.add(b);
        Icon3 c = new Icon3(R.drawable.recycle2,"2019年年度歌单","10首",R.drawable.button_more);
        iconList3.add(c);
        Icon3 e = new Icon3(R.drawable.recycle5,"女声控|那些一曲惊人的古风歌","11首",R.drawable.button_more);
        iconList4.add(e);
        Icon3 f = new Icon3(R.drawable.recycle6,"感动心灵的99首ACG旋律","99首",R.drawable.button_more);
        iconList4.add(f);
        Icon3 g = new Icon3(R.drawable.recycle7,"mine","76首",R.drawable.button_more);
        iconList4.add(g);
        Icon3 h = new Icon3(R.drawable.recycle8,"lings","23首",R.drawable.button_more);
        iconList4.add(h);
    }
}
