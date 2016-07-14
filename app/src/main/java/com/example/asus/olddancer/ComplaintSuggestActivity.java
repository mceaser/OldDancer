package com.example.asus.olddancer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/9.
 */
public class ComplaintSuggestActivity extends Activity{

    private Button button;
    private Button button_commit;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_complaintsuggest);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_commit=(Button)findViewById(R.id.button_commit);
        button_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"反馈成功",Toast.LENGTH_LONG).show();
            }
        });

    }
}
