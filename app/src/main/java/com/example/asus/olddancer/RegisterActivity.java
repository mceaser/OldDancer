package com.example.asus.olddancer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/7/19.
 */
public class RegisterActivity extends Activity{

    private Button preservation;
    private EditText user_name;
    private EditText pass_word;
    private String username;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        View v1=findViewById(R.id.username_editText);
        v1.getBackground().setAlpha(20);
        View v2=findViewById(R.id.password_editText);
        v2.getBackground().setAlpha(20);

        user_name=(EditText)findViewById(R.id.username_editText);
        pass_word=(EditText)findViewById(R.id.password_editText);

        preservation=(Button)findViewById(R.id.preservation_button);
        preservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser user=new BmobUser();
                user.signUp(RegisterActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_LONG).show();
                    }
                });
                Intent intent=new Intent(RegisterActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
