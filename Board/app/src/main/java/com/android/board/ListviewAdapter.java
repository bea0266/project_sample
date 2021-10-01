package com.android.board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    private ArrayList<ListviewItem> listviewItemList = new ArrayList<ListviewItem>() ;
    @Override
    public int getCount() {
        return listviewItemList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return listviewItemList.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView hitTextView = (TextView) convertView.findViewById(R.id.tvHit);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView descTextView = (TextView) convertView.findViewById(R.id.tvDesc);
        TextView writerTextView = (TextView) convertView.findViewById(R.id.tvWrite);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.tvDate);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListviewItem listviewItem = listviewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        hitTextView.setText(Integer.toString(listviewItem.getHit()));
        titleTextView.setText(listviewItem.getTitle());
        descTextView.setText(listviewItem.getDesc());
        writerTextView.setText(listviewItem.getWrite());
        dateTextView.setText(listviewItem.getDate());

        return convertView;

    }

    public void addItem(String title, String desc, int hits, String writer, String date){
        ListviewItem item = new ListviewItem();

        item.setDate(date);
        item.setWrite(writer);
        item.setHit(hits);
        item.setTitle(title);
        item.setDesc(desc);

        listviewItemList.add(item);
    }
}
