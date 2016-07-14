package com.example.asus.olddancer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/7/13.
 */
public class Setting_safe_password_Activity extends Activity{

    private Button button;
    private Button button_sure;
    private EditText editText_old;
    private EditText editText_new;
    private EditText editText_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_setting_safe_password);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_sure=(Button)findViewById(R.id.button_sure);
        button_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Setting_safe_password_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO Auto-generated method stub
        if (isChecked) {
            editText_old.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            editText_new.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            editText_old.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
            editText_old.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editText_new.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editText_again.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
}
