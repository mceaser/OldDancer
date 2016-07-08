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

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class knowledge extends Fragment implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener {

    private static int [] arr_item={R.layout.list_item_knowledge1,R.layout.list_item_knowledge1,R.layout.list_item_knowledge1,R.layout.list_item_knowledge1,};
    private static int[] arr_pic={R.drawable.pic_demo_food,R.drawable.pic_demo_water,R.drawable.pic_demo_sleep,R.drawable.pic_demo_sport,};
    private static String[] title={"食","饮","眠","动"};
    private static String[] description={"夏季潮湿多热，应多食用去湿食物","高温天气，应多饮水","成年人以8小时睡眠最适宜","紫外线危害大，室内运动好处多"};

    public knowledge() {

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_konwledge, container, false);
        ListView list_knowledge = (ListView)view.findViewById(R.id.list_knowledge);


        List<Map<String,Object>>data=getData();
        int itemLayout=R.layout.list_item_knowledge1;
        String[] from=new String[]{"pic","title","description","item"};
        int[]to=new int[]{R.id.pic_food,R.id.title,R.id.description,R.layout.list_item_knowledge1};
        SimpleAdapter sadapter=new SimpleAdapter(getActivity(),data,itemLayout,from,to);
        list_knowledge.setAdapter(sadapter);
        list_knowledge.setItemsCanFocus(false);
        list_knowledge.setOnItemClickListener(this);
        return view;
    }


    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> datalist = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Map<String, Object> map = new HashMap<>();//
            map.put("pic", arr_pic[i]);
            map.put("title",title[i]);
            map.put("description", description[i]);
            datalist.add(map);
        }
        return datalist;
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

//   public class Knowledge extends ListFragment{
//
//    public Map<String,String>map;
//    public  String tag=this.getClass().getSimpleName();
//    public Context context;  //储存上下文对象
//    public Activity activity;//储存上下文对象
//
//
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        context=getActivity();
//        activity=getActivity();
//
//    }
//
//
//}