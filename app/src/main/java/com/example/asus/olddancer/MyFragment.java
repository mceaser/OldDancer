package com.example.asus.olddancer;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by asus on 2016/7/5.
 */
   @SuppressLint("ValidFragment")
   public class MyFragment extends Fragment {
    String  content;
    @SuppressLint("ValidFragment")
    public MyFragment(String content) {
        this.content=content;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        TextView txt_content = (TextView)
        view.findViewById(R.id.txt_content);
        txt_content.setText(content);
        return view;
    }
}







