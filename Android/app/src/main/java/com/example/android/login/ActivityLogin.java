package com.example.android.login;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.Faxian.FaXianActivity;
import com.example.android.R;
public class ActivityLogin extends Activity {
    private Context context;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginbutton = findViewById(R.id.button_login);
        context = this;
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userid = findViewById(R.id.input_email);
                EditText password = findViewById(R.id.input_password);
                if(userid.getText().toString().equals("admin")){
                    if(password.getText().toString().equals("admin")){
                        Intent intent = new Intent();
                        intent.putExtra("用户 ","已登录");
                        setResult(RESULT_OK, intent);
                        finish();
                        Intent intent1 = new Intent(ActivityLogin.this, FaXianActivity.class);
                        startActivity(intent1);
                    }
                    else{
                        Toast t = Toast.makeText(context,"密码错误，请重新输入", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
                else{
                    Toast t = Toast.makeText(context,"用户名不存在!", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }

}
