package com.example.asus.olddancer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/7/13.
 */
public class Setting_safe_phone_Activity extends Activity{

    private Button button;
    private Button button_change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_setting_safe_phone);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_change=(Button)findViewById(R.id.button_change);
        button_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Setting_safe_phone_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
