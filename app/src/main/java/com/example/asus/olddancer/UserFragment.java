package com.example.asus.olddancer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/8.
 */
public class UserFragment extends Fragment implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{

    private ListView listview;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>>dataList;
    private int[] image={R.drawable.list,R.drawable.invite,R.drawable.grade,R.drawable.download,R.drawable.history,R.drawable.suggest,R.drawable.setting};
    private String[] theme={"我的舞单","邀请好友","积分等级","我的下载","观看记录","投诉建议","设置"};
    //private int[] image2={R.drawable.larger,R.drawable.larger,R.drawable.larger,R.drawable.larger,R.drawable.larger,R.drawable.larger,R.drawable.larger};
    public UserFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.user_layout,container,false);
        ListView listView=(ListView)view.findViewById(R.id.listView);
        TextView textView=(TextView)view.findViewById(R.id.textView);
//        List<Map<String,Object>> listitem=new ArrayList<Map<String,Object>>();
//        for(int i=0;i<image.length;i++){
//            Map<String,Object> showitem=new HashMap<String,Object>();
//            showitem.put("image",image[i]);
//            showitem.put("theme",theme[i]);
//            showitem.put("image2",R.drawable.larger);
//            listitem.add(showitem);
//        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this.getActivity(),getData(),R.layout.list_item_layout,new String[]{"image","theme","image2"},new int[]{R.id.image,R.id.theme,R.drawable.larger});
        listView.setAdapter(simpleAdapter);
        return view;
    }
    private List<Map<String, Object>> getData(){
        List<Map<String,Object>> listitem=new ArrayList<Map<String,Object>>();
        for(int i=0;i<image.length;i++){
            Map<String,Object> showitem=new HashMap<String,Object>();
            showitem.put("image",image[i]);
            showitem.put("theme",theme[i]);
            showitem.put("image2",R.drawable.larger);
            listitem.add(showitem);
        }
        return listitem;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

}
