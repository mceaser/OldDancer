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
 * Created by Administrator on 2016/7/9.
 */
public class SettingActivity extends Activity{

    private Button button1;
    private Button button2;
    private ListView listView;
    //定义一个动态数组
    ArrayList<HashMap<String, Object>> listitem;
    public String[] string={"关于","账号与安全"};

    private ArrayList<HashMap<String,Object>> getData(){
        listitem=new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<string.length;i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("title",string[i]);
            map.put("image",R.drawable.larger);
            listitem.add(map);
        }

        return listitem;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_setting);

        button1 = (Button) findViewById(R.id.button_setting);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.list_setting);

        listitem=getData();

        //得到MyAdapter对象
        MyAdapter adapter = new MyAdapter(this);
        //为ListView绑定Adapter*/
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;
                switch (position){
                    case 0:
                        intent=new Intent(SettingActivity.this,Setting_about_Activity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(SettingActivity.this,Setting_safe_Activity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }


     private class MyAdapter extends BaseAdapter {

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
                convertView=mInflater.inflate(R.layout.list_item_setting_listview,null);
                holder=new ViewHolder();
                holder.title=(TextView)convertView.findViewById(R.id.title);
                holder.image=(ImageView)convertView.findViewById(R.id.image);
                //holder.button=(Button)convertView.findViewById(R.id.button);
                //绑定ViewHolder对象
                convertView.setTag(holder);
            }else{
                //取出ViewHolder对象
                holder=(ViewHolder)convertView.getTag();
            }
            holder.title.setText(getData().get(position).get("title").toString());
            holder.image.setBackgroundResource((Integer)listitem.get(position).get("image"));

            return convertView;
        }
    }

    public final class ViewHolder{
        public TextView title;
        public ImageView image;
        //public Button button;
    }
}
