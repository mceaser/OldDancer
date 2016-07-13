package com.example.asus.olddancer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Setting_safe_Activity extends Activity{

    private Button button;
    private ListView listView;
    private String[] text_title={"手机号","修改密码"};
    ArrayList<HashMap<String,Object>> listitem;

    private ArrayList<HashMap<String,Object>> getData(){
        listitem=new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<text_title.length;i++){
            HashMap<String,Object> map=new HashMap<String,Object>();
            map.put("text_title",text_title[i]);
            map.put("image_view",R.drawable.larger);
            listitem.add(map);
        }
        return listitem;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_setting_safe);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Setting_safe_Activity.this,SettingActivity.class);
                startActivity(intent);
            }
        });



        listView=(ListView) findViewById(R.id.list_password);

        listitem=getData();

        MyAdapter adapter=new MyAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;
                switch (position){
                    case 0:
                        intent=new Intent(Setting_safe_Activity.this,Setting_safe_phone_Activity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(Setting_safe_Activity.this,Setting_safe_password_Activity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    private class MyAdapter extends BaseAdapter{

        private LayoutInflater mInflater;
        public MyAdapter(Context context){
            this.mInflater=LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return listitem.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=mInflater.inflate(R.layout.list_item_setting_safe_listview,null);
                holder=new ViewHolder();
                holder.text_title=(TextView)convertView.findViewById(R.id.text_title);
                holder.image_view=(ImageView)convertView.findViewById(R.id.image_view);
                convertView.setTag(holder);
            }else {
                holder=(ViewHolder)convertView.getTag();
            }
            holder.text_title.setText(getData().get(position).get("text_title").toString());
            holder.image_view.setBackgroundResource((Integer)listitem.get(position).get("image_view"));
//            if(position==0) {
//                holder.text_title.setText("手机号");
//                holder.image_view.setImageResource(R.drawable.larger);
//            }else {
//                holder.text_title.setText("修改密码");
//                holder.image_view.setImageResource(R.drawable.larger);
//            }
            return convertView;
        }
    }

    public final class ViewHolder{
        public TextView text_title;
        public ImageView image_view;
    }
}
