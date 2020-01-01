package com.example.android.Bofang;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BofangActivity extends AppCompatActivity implements View.OnClickListener {

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
    private int totalTime;//“歌曲总时长，用于获取歌曲时长”
    private SeekBar jindutiaoSb; //"进度条"
    private boolean isStop;//“停止”
    private int position;
    private float zhizhenmap;

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
//获取传值
        Intent intent = getIntent();
        position = intent.getIntExtra("i", 0);//将传入的值赋给position
//获取mediaplayer
        mediaPlayer = new MediaPlayer();


        Link();//绑定ID方法
        play();//歌曲播放及一系列操作方法

/////////////////////////获取进度条点击位置并使歌曲跳转到该位置////////////////////////////////////
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

        mediaPlayer.reset();//进行重置
        Music music = Common.musicList.get(position);//获取传来的值
        Bitmap disces = BitmapFactory.decodeResource(getResources(), R.drawable.hejiaochangpian);


        //歌曲播放
        try {
            mediaPlayer.setDataSource(music.path);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
        totalTv.setText(formatTime(music.length));
        totalTime = music.length;
        new Thread(new SeekBarThread()).start();
        jindutiaoSb.setMax(music.length);

        //指针拨动
        animator1 = ObjectAnimator.ofFloat(zhizhenmap, "rotation", -60f, 0.0f);
        animator1.setDuration(900);
        animator1.setRepeatCount(0);//设置动画重复次数（-1代表一直转）
        animator1.start();




    }

//    获取歌曲时长
    private String formatTime(int length) {
        Date date = new Date(length);//调用Date方法获值
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");//规定需要形式
        String TotalTime = simpleDateFormat.format(date);//转化为需要形式

        return TotalTime;

    }
//    新建方法link（）进行绑定ID
    private void Link() {

        backIv = findViewById(R.id.last);
        nextIv = findViewById(R.id.next);
        discsmap = findViewById(R.id.changpian);
        pauseIv = findViewById(R.id.pause);
        currentTv = findViewById(R.id.time);
        totalTv = findViewById(R.id.song_length);
        jindutiaoSb = findViewById(R.id.jindutiao);

    }

    //设置事件监听
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.last://当点击“上一首”按钮
                position--;//数组递减
                if (position == -1) {
                    position = Common.musicList.size() - 1;
                }
                play();
                break;
            case R.id.next://当点击“下一首”按钮
                position++;
                if (position == Common.musicList.size()) {
                    position = 0;
                }
                play();
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
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }


}


