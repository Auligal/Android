package com.example.android.cloudvileage;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.android.R;
import com.example.android.cloudvileage.recy.icon;
import com.example.android.cloudvileage.recy.iconAdapter;
import java.util.ArrayList;
import java.util.List;
public class cloudvillegActivity extends AppCompatActivity {
    List<icon> list = new ArrayList<icon>();
    List<icon> list2 = new ArrayList<icon>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloudvilleg);
        init();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        iconAdapter iconAdapter = new iconAdapter(list,cloudvillegActivity.this);
        iconAdapter iconAdapter2 = new iconAdapter(list2,cloudvillegActivity.this);
        recyclerView.setAdapter(iconAdapter);
        recyclerView2.setAdapter(iconAdapter2);
        MyLinearLayoutManager layoutManager = new MyLinearLayoutManager(this);
        MyLinearLayoutManager layoutManager2 = new MyLinearLayoutManager(this);
        layoutManager.setScrollEnabled(false);
        layoutManager2.setScrollEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);
    }
    private void init(){
        icon a = new icon(R.drawable.cv_1,"唱歌是因为有爱,听听生活的诉说",R.drawable.person1,"阿刁121","211赞");
        icon b = new icon(R.drawable.cv_2,"你向往的生活是什么呢？",R.drawable.person2,"做那月亮多好","111赞");
        icon c = new icon(R.drawable.cv_3,"我们说好了 你保护世界 我喜欢一个人，我想要",R.drawable.person3,"墨枫山","434赞");
        icon d = new icon(R.drawable.cv_4,"他一世孤傲，征战四方，他花天酒地，不理朝政，他看她的第一眼",R.drawable.person4,"忆-幜烟","211赞");
        icon e = new icon(R.drawable.cv_5,"唱歌是因为有爱,听听生活的诉说",R.drawable.person5,"星也集","653赞");
        icon f = new icon(R.drawable.cv_6,"唱歌是因为有爱,听听生活的诉说",R.drawable.person6,"漫宅歌","172赞");
        icon g = new icon(R.drawable.cv_7,"唱歌是因为有爱,听听生活的诉说",R.drawable.person1,"阿刁121","211赞");
        icon h = new icon(R.drawable.cv_8,"你向往的生活是什么呢？",R.drawable.person2,"做那月亮多好","111赞");
        icon i = new icon(R.drawable.cv_9,"我们说好了 你保护世界 我喜欢一个人，我想要",R.drawable.person3,"墨枫山","434赞");
        icon j = new icon(R.drawable.cv_10,"他一世孤傲，征战四方，他花天酒地，不理朝政，他看她的第一眼",R.drawable.person4,"忆-幜烟","211赞");
        icon k = new icon(R.drawable.cv_11,"唱歌是因为有爱,听听生活的诉说",R.drawable.person5,"星也集","653赞");
        icon l = new icon(R.drawable.cv_12,"唱歌是因为有爱,听听生活的诉说",R.drawable.person6,"漫宅歌","172赞");
        icon m = new icon(R.drawable.cv_13,"唱歌是因为有爱,听听生活的诉说",R.drawable.person1,"阿刁121","211赞");
        icon n = new icon(R.drawable.cv_14,"你向往的生活是什么呢？",R.drawable.person2,"做那月亮多好","111赞");
        icon o = new icon(R.drawable.cv_15,"我们说好了 你保护世界 我喜欢一个人，我想要",R.drawable.person3,"墨枫山","434赞");
        icon p = new icon(R.drawable.cv_16,"他一世孤傲，征战四方，他花天酒地，不理朝政，他看她的第一眼",R.drawable.person4,"忆-幜烟","211赞");
        icon q = new icon(R.drawable.cv_17,"唱歌是因为有爱,听听生活的诉说",R.drawable.person5,"星也集","653赞");
        icon r = new icon(R.drawable.cv_18,"唱歌是因为有爱,听听生活的诉说",R.drawable.person6,"漫宅歌","172赞");
        icon s = new icon(R.drawable.cv_19,"唱歌是因为有爱,听听生活的诉说",R.drawable.person1,"阿刁121","211赞");
        icon t = new icon(R.drawable.cv_20,"你向往的生活是什么呢？",R.drawable.person2,"做那月亮多好","111赞");
        icon u = new icon(R.drawable.cv_21,"我们说好了 你保护世界 我喜欢一个人，我想要",R.drawable.person3,"墨枫山","434赞");
        icon v = new icon(R.drawable.cv_22,"他一世孤傲，征战四方，他花天酒地，不理朝政，他看她的第一眼",R.drawable.person4,"忆-幜烟","211赞");
        icon w = new icon(R.drawable.cv_23,"唱歌是因为有爱,听听生活的诉说",R.drawable.person5,"星也集","653赞");
        icon x = new icon(R.drawable.cv_24,"唱歌是因为有爱,听听生活的诉说",R.drawable.person6,"漫宅歌","172赞");
        icon y = new icon(R.drawable.cv_25,"唱歌是因为有爱,听听生活的诉说",R.drawable.person1,"阿刁121","211赞");
        icon z = new icon(R.drawable.cv_26,"你向往的生活是什么呢？",R.drawable.person2,"做那月亮多好","111赞");
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

        list2.add(n);
        list2.add(o);
        list2.add(p);
        list2.add(q);
        list2.add(r);
        list2.add(s);
        list2.add(t);
        list2.add(u);
        list2.add(v);
        list2.add(w);
        list2.add(x);
        list2.add(y);
        list2.add(z);
    }
}
