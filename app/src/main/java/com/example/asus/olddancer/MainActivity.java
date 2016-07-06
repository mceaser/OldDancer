package com.example.asus.olddancer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {
    //UI Object
    private  TextView txt_top_bar;
    private  TextView txt_home;
    private TextView txt_interact;
    private TextView txt_mine;
    private FrameLayout ly_content;
    Fragment object;
    MyFragment fg1,fg2,fg3;
    private android.app.FragmentManager fManager;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager =getFragmentManager();
        bindViews();
        txt_home.performClick();//模拟一次点击
    }

    private  void bindViews() {
        txt_top_bar = (TextView) findViewById(R.id.txt_topbar);
        txt_home = (TextView) findViewById(R.id.txt_home);
        txt_interact = (TextView) findViewById(R.id.txt_interaction);
        txt_mine = (TextView) findViewById(R.id.txt_mine);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_home.setOnClickListener(this);
        txt_interact.setOnClickListener(this);
        txt_mine.setOnClickListener(this);
    }


    //重置所有文本的选择状态
    private void setSelected(){
        txt_mine.setSelected(false);
        txt_interact.setSelected(false);
        txt_home.setSelected(false);
    }


    //隐藏所有的Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){

        if (fg1!=null){
            fragmentTransaction.hide(fg1);
            if (fg2!=null)fragmentTransaction.hide(fg2);
                if (fg3!=null)fragmentTransaction.hide(fg3);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (v.getId())
        {
            case R.id.txt_home:
                setSelected();
                txt_home.setSelected(true);
                if (fg1==null){
                    fg1=new MyFragment("功能主页");
                    fragmentTransaction.add(R.id.ly_content,fg1);
                }else {
                    fragmentTransaction.show(fg1);
                }break;

            case R.id.txt_interaction:
                setSelected();
                txt_interact.setSelected(true);
                if (fg2==null) {
                    fg2 = new MyFragment("养生知识");
                    fragmentTransaction.add(R.id.ly_content, fg2);
                }else {
                    fragmentTransaction.show(fg2);
                }break;

            case  R.id.txt_mine:
                setSelected();
                txt_mine.setSelected(true);
                if (fg3==null) {
                    fg3 = new MyFragment("用户");
                    fragmentTransaction.add(R.id.ly_content, fg3);
                }else {
                    fragmentTransaction.show(fg3);
                }break;
        }
        fragmentTransaction.commit();
    }
}
