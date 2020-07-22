package com.cos.listviewex02;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleAdapter extends BaseAdapter {

    private static final String TAG = "SingleAdapter";
    private List<String> items = new ArrayList<>();

    // 어댑터는 데이터를 알고 있어야함 → 리스트를 구축하기 위해서
    public void addItems(List<String> items) {
        this.items = items; // 데이터를 한 번에 담음
    }

    @Override
    public int getCount() { // * 아이템 총 사이즈 → 화면 뷰 사이즈 계산
        return items.size();
    }

    @Override
    public Object getItem(int position) { // * 해당 리스트 자리에 있는 데이터 들고오기
        return items.get(position);
    }

    @Override
    public long getItemId(int position) { // 데이터의 Primary Key 개념
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: " + position);
        // *** 뷰를 생성하는 함수 : 최초에 onCreate 될 때 총 몇 개의 View 올려야 하는지 결정
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); // inflater 객체 얻음 : inflater로 View를 메모리에 띄우기 위해서
        View itemView = inflater.inflate(R.layout.item, parent, false); // view 객체 얻음
        // 최초 OnCreate 될 때 6개의 view 뜨고, 6번 리스트 지나서 7번부터 getItem 호출됨!
        TextView tv = itemView.findViewById(R.id.tv_title);
        tv.setText(getItem(position).toString());
        return itemView;
    }
}
