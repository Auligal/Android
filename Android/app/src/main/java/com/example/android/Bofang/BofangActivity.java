package com.example.android.Bofang;
import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BofangActivity extends AppCompatActivity implements View.OnClickListener {
    List<Music> musicList = new ArrayList<>();
    //定义各类控件
    private ImageView backIv;
    private ImageView nextIv;//"下一首"
    private ImageView discsmap;//"唱片"
    private ImageView pauseIv;//“暂停”
    private MediaPlayer mediaPlayer;//"MediaPlayer"
    private ObjectAnimator animator;//运用ObjectAnimator实现转动
    private ObjectAnimator animator1;
    private TextView currentTv;//"当前时间"
    private TextView totalTv;//“歌曲总时间”
    private SeekBar jindutiaoSb; //"进度条"
    private boolean isStop;//“停止”
    private int position;
    private TextView bofang_geming;
    private TextView singer;
    private TextView zhuanji;
    private ImageView changpian;
    List<Music> music_list = new ArrayList<>();
    private  float zhizhenmap;
    //定义Handler进行接收多线程信息，安卓中不允许主线程实现UI更新
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            jindutiaoSb.setProgress(msg.what);
            currentTv.setText(formatTime(msg.what));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bofang);

        backIv = findViewById(R.id.last);
        nextIv = findViewById(R.id.next);
        discsmap = findViewById(R.id.changpian);
        pauseIv = findViewById(R.id.pause);
        currentTv = findViewById(R.id.time);
        totalTv = findViewById(R.id.song_length);
        jindutiaoSb = findViewById(R.id.jindutiao);
        bofang_geming = findViewById(R.id.bofang_geming);
        singer = findViewById(R.id.singer);
        zhuanji = findViewById(R.id.zhuanji);
        changpian = findViewById(R.id.changpian);
        initmusic();
//获取传值
        Intent intent = getIntent();
        String sposition = intent.getStringExtra("music");
        position = Integer.parseInt(sposition);//将传入的值赋给position

//获取mediaplayer
        mediaPlayer = new MediaPlayer();
        play();//歌曲播放及一系列操作方法
        jindutiaoSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(i);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    //新建play（）方法用于歌曲播放、唱片打碟功能，及进度条简要设置
    private void play() {
        mediaPlayer.reset();
        mediaPlayer = new MediaPlayer();
        if(position==3)
            position=0;
        if(position==-1)
            position = 2;
        File file = new File(music_list.get(position).getUrl());
        bofang_geming.setText(music_list.get(position).getName());
        singer.setText(music_list.get(position).getSinger());
        zhuanji.setText("  "+music_list.get(position).getName());
        changpian.setImageResource(music_list.get(position).getChangpian());
        try {
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap disces = BitmapFactory.decodeResource(getResources(), R.drawable.hejiaochangpian);
        backIv.setOnClickListener(this);
        nextIv.setOnClickListener(this);
        pauseIv.setOnClickListener(this);
        //唱片打碟
        animator = ObjectAnimator.ofFloat(discsmap, "rotation", 0f, 360.0f);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());//匀速
        animator.setRepeatCount(-1);//设置动画重复次数（-1代表一直转）
        animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        animator.start();
        //进度条
        totalTv.setText(formatTime(music_list.get(position).getAlltime()));
        new Thread(new SeekBarThread()).start();
        jindutiaoSb.setMax(music_list.get(position).getAlltime());
        //指针拨动
        animator1 = ObjectAnimator.ofFloat(zhizhenmap, "rotation", -60f, 0.0f);
        animator1.setDuration(900);
        animator1.setRepeatCount(0);//设置动画重复次数（-1代表一直转）
        animator1.start();
    }
//    获取歌曲时长
    private String formatTime(int length) {
        Date date = new Date(length);//调用Date方法获值
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");//规定需要形式
        return simpleDateFormat.format(date);
    }
    //设置事件监听
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.last://当点击“上一首”按钮
                position--;//数组递减
                if (position == -1) {
                    position = musicList.size() - 1;
                }
                pauseIv.setImageResource(R.drawable.ic_pause_white_36dp);
                play();
                break;
            case R.id.next://当点击“下一首”按钮
                position++;
                if (position == musicList.size()) {
                    position = 0;
                }
                pauseIv.setImageResource(R.drawable.ic_pause_white_36dp);
                play();
                break;
            case R.id.pause:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();//当正在播放时，点击“暂停”
                    animator.pause();
                    pauseIv.setImageResource(R.drawable.ic_play_white_36dp);
                } else {
                    mediaPlayer.start();//播放
                    pauseIv.setImageResource(R.drawable.ic_pause_white_36dp);
                    animator.resume();
                    animator1.resume();
                }
            default:
                break;
        }
    }
    //建立销毁方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.reset();
        isStop = true;
    }
    //运用多线程进行进度条及位置更新
    class SeekBarThread implements Runnable {
        @Override
        public void run() {
            while (mediaPlayer != null && isStop == false) {
                // 将SeekBar位置设置到当前播放位置
                handler.sendEmptyMessage(mediaPlayer.getCurrentPosition());
                try {
                    // 每100毫秒更新一次位置
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void initmusic(){
        Music a = new Music(166580,R.drawable.p1_1,"卷珠帘","/storage/self/primary/netease/cloudmusic/Music/周深 - 卷珠帘.mp3","周深",R.drawable.hjcp1);
        Music b= new Music(230000,R.drawable.p1_2,"白露","/storage/self/primary/netease/cloudmusic/Music/封茗囧菌 - 白露（节气物语系列）.mp3","封茗囧菌",R.drawable.hjcp2);
        Music c = new Music(205000,R.drawable.p1_3,"夜宴风波","/storage/self/primary/netease/cloudmusic/Music/泠鸢yousa - 夜宴风波【泠鸢·翻唱】（Cover：音阙诗听）.mp3","泠鸢",R.drawable.hjcp3);
        music_list.add(a);
        music_list.add(b);
        music_list.add(c);

    }
}


