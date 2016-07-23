package com.example.asus.olddancer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/7/17.
 */
public class LogInActivity extends Activity{

    private Button login_button;
    private Button register_button;
    private Button forgetpassword_button;
    private EditText user_name;
    private EditText pass_word;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bmob.initialize(this, "3b44e0e83a441c40923d1270cb2b8b12");

        setContentView(R.layout.login_layout);

        View v1=findViewById(R.id.username_editText);
        v1.getBackground().setAlpha(20);
        View v2=findViewById(R.id.password_editText);
        v2.getBackground().setAlpha(20);

        user_name=(EditText)findViewById(R.id.username_editText);
        pass_word=(EditText)findViewById(R.id.password_editText);

        login_button=(Button)findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=user_name.getText().toString();
                password=pass_word.getText().toString();
                BmobUser user=new BmobUser();
                user.setUsername(username);
                user.setPassword(password);
                user.login(LogInActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(LogInActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(LogInActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intent=new Intent(LogInActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });

        register_button=(Button)findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogInActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        forgetpassword_button=(Button)findViewById(R.id.forgetpassword_button);
        forgetpassword_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogInActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

    }
}
