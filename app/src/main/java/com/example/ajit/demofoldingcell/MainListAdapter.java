package com.example.ajit.demofoldingcell;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;

/**
 * Created by Ajit on 14-02-2018.
 */

public class MainListAdapter extends BaseAdapter {
    Activity mactivity;
//    ChildListAdapter childListAdapter;
    String[] value;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    ListView list_child,list_parent;
    public String[] day={"One","Two","Three","Four","Five","Six","Seven"};
    MainListAdapter(Activity activity,String[] value)
    {
        this.mactivity=activity;
        this.value=value;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=mactivity.getLayoutInflater();

        FoldingCell cell = (FoldingCell) view;
        cell=(FoldingCell) inflater.inflate(R.layout.cell,viewGroup,false);
        TextView tv_week_name=cell.findViewById(R.id.tv_week_name);
        list_child=(ListView)cell.findViewById(R.id.list_view_child);
        //list_child=v.findViewById(R.id.list_child);
        tv_week_name.setText(value[i]);
        ChildListAdapter adapter=new ChildListAdapter(mactivity,day);
        list_child.setAdapter(adapter);
        final FoldingCell finalCell = cell;
        list_child.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if(list_parent != null) {
                        ((ViewParent)list_parent).requestDisallowInterceptTouchEvent(true);
                    }
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(list_parent != null) {
                        ((ViewParent)list_parent).requestDisallowInterceptTouchEvent(false);
                    }
                }
                /*if (unfoldedIndexes.contains(i)) {
                    finalCell.unfold(true);
                } else {
                    finalCell.fold(true);
                }*/

                return false;
            }
        });
        final FoldingCell finalCell1 = cell;
        list_child.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final FoldingCell toggleCell = finalCell;
                toggleCell.toggle(false);
                registerToggle(i);
                TextView child_tv= (TextView) view.findViewById(R.id.tv_list_day);
                TextView tv = (TextView) finalCell1.findViewById(R.id.tv_week_name);
                Toast.makeText(mactivity, tv.getText().toString()+" "+child_tv.getText().toString()
                        , Toast.LENGTH_SHORT).show();
            }
        });






        final FoldingCell toggleCell = cell;

        tv_week_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleCell.toggle(false);
                registerToggle(i);
            }
        });
        return cell;
    }

    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }
    public void setParentListView(ListView listView)
    {
        this.list_parent=listView;
    }


}
