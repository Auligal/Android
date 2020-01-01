package com.example.android.Wode.MusicMenu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toolbar;

import com.example.android.R;

import java.util.ArrayList;
import java.util.List;

public class MusicMenuActivity extends AppCompatActivity {
    private List<Icon> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_menu);
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        init();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        IconAdapter adapter = new IconAdapter(list,MusicMenuActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    private void init(){
        Icon a = new Icon(1,"一样的月光","徐佳莹-LaLa首张创作专辑");
        Icon b = new Icon(2,"身骑白马","徐佳莹-LaLa首张创作专辑");
        Icon c = new Icon(3,"爱殇","小时姑娘-小时姑娘2009");
        Icon d = new Icon(4,"一样的月光","miwa-mima2001");
        Icon e = new Icon(5,"We Are the Champions","Queen-Absolute Greatest");
        Icon f = new Icon(6," 成为一个厉害的人","路人甲");
        Icon g = new Icon(7,"年少有为","路人丙-路人丙");
        Icon h = new Icon(8,"匆匆","路人甲");
        Icon i = new Icon(9,"入海","路人丙-路人丁");
        Icon j = new Icon(10,"二十七八","路人甲");
        Icon k = new Icon(11,"哗啦啦少年再见","路人丙-路人丁");
        Icon l = new Icon(12,"地下铁","路人甲");
        Icon m = new Icon(13,"另一个天堂","路人丁-路人丁");
        Icon n = new Icon(14,"在希望的田野上","路人丙-路人丙");
        Icon o = new Icon(15,"火车开过破晓","Curley G");
        Icon p = new Icon(16,"夜昼","LuckyMaxx / Curley G");
        Icon q = new Icon(17,"好运来","路人丁-骑马的火柴人");
        Icon r = new Icon(18,"霜雪千年","路人丁-路人丙");
        Icon s = new Icon(19,"上海滩","路人丁-路人丙");
        Icon t = new Icon(20,"无心","路人甲");
        Icon u = new Icon(21,"离别","徐佳莹-骑马的火柴人");
        Icon v = new Icon(22,"你还记得吗","路人丁");
        Icon w = new Icon(23,"上一次晚餐","路人丙");
        Icon x = new Icon(24,"最后的那个人","路人甲");
        Icon y = new Icon(25,"人热","骑马的火柴人");
        Icon z = new Icon(26,"心中的那个他","炮灰乙");
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        list.add(i);
        list.add(j);
        list.add(k);
        list.add(l);
        list.add(m);
        list.add(n);
        list.add(o);
        list.add(p);
        list.add(q);
        list.add(r);
        list.add(s);
        list.add(t);
        list.add(u);
        list.add(v);
        list.add(w);
        list.add(x);
        list.add(y);
        list.add(z);
    }
}
