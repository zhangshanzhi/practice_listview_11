package com.example.practice_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Map;


public class MyAdapter extends BaseAdapter {

    List<Map<String,Object>> list;
    LayoutInflater inflater;

    public MyAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    @Override
    //获取listview
    public int getCount() {
        return list.size();
    }

    //下两方法不必要实现
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //系统在渲染每行内容时调用getview然后返还一个position0
        //返还view是什么就画什么 若是return null那么什么都不画 return什么样的对象画出什么
            //依靠反射器把xml文本文件反射成view
        View view =inflater.inflate(R.layout.test1,null);//没有必要提供根节点

        ImageView logo = (ImageView) view.findViewById(R.id.logo);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView version = (TextView) view.findViewById(R.id.version);
        TextView size = (TextView) view.findViewById(R.id.size);

        //position 参数
        Map map = list.get(position);
        logo.setImageResource((Integer) map.get("logo"));
        title.setText((String) map.get("title"));
        version.setText((String) map.get("version"));
        size.setText((String) map.get("size"));

        //logo,version等等相互牵连
        return view;
    }

}
