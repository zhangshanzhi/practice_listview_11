package com.example.practice_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //拿到listview对象
        ListView lv = (ListView) this.findViewById(R.id.lv_main);

        //数据源
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_3);
        map.put("title", "wdnmd");
        map.put("version", "1.0");
        map.put("size", "10MB");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_2);
        map.put("title", "wcnmd");
        map.put("version", "1.4");
        map.put("size", "10,1MB");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_5);
        map.put("title", "wknmd");
        map.put("version", "1.3");
        map.put("size", "10.3MB");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_4);
        map.put("title", "wknmd");
        map.put("version", "1.2");
        map.put("size", "10.4MB");
        list.add(map);

        //适配器
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.test1,
                new String[]{"logo","title","version","size"},
                new int[]{R.id.logo,R.id.title,R.id.version,R.id.size}

        );*/

        //自定义adapter 期中包含一个list一个反射器inflater，在inflater中为行布局，list中为所有数据
        MyAdapter adapter = new MyAdapter(this);
        adapter.setList(list);  //传入数据 √

        //关联适配器
        lv.setAdapter(adapter);

        //敲击

    }

}
