package com.example.ajit.demofoldingcell;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Ajit on 14-02-2018.
 */

public class ChildListAdapter extends BaseAdapter {

    Activity mactivity;
    String[] value;
    TextView tv_list_day;

    ChildListAdapter(Activity activity, String[] value) {
        this.mactivity = activity;
        this.value = value;
    }
    ChildListAdapter(ListView parent)
    {

    }

    @Override
    public int getCount() {
        return value.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = mactivity.getLayoutInflater();
        View v = inflater.inflate(R.layout.list_child, viewGroup, false);
     tv_list_day = v.findViewById(R.id.tv_list_day);
        tv_list_day.setText(value[i]);
//        tv_list_day.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    if(parentListView != null) {
//                        ((ViewParent)parentListView).requestDisallowInterceptTouchEvent(true);
//                    }
//                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
//                    if(parentListView != null) {
//                        ((ViewParent)parentListView).requestDisallowInterceptTouchEvent(false);
//                    }
//                }
//                return false;
//            }
//        });


        return v;
    }

}
