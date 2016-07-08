package com.example.asus.olddancer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/8.
 */
public class UserFragment extends Fragment {

    private ListView listview1;
    private ListView listview2;
    private int[] image1={R.drawable.list,R.drawable.invite,R.drawable.grade};
    private int[] image2={R.drawable.download,R.drawable.history,R.drawable.suggest,R.drawable.setting};
    private String[] theme1={"我的舞单","邀请好友","积分等级"};
    private String[] theme2={"我的下载","观看记录","投诉建议","设置"};
    private int[] image3={R.drawable.larger,R.drawable.larger,R.drawable.larger};
    private int[] image4={R.drawable.larger,R.drawable.larger,R.drawable.larger,R.drawable.larger};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.user_layout,container,false);
        ListView listView1=(ListView)view.findViewById(R.id.listView1);
        ListView listView2=(ListView)view.findViewById(R.id.listView2);
        TextView textView=(TextView)view.findViewById(R.id.textView1);
        return view;
    }
}
