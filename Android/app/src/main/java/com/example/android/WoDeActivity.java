package com.example.android;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class WoDeActivity extends AppCompatActivity {

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


    }
}
