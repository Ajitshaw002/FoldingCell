package com.example.ajit.demofoldingcell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

public class MainActivity extends AppCompatActivity {

    private ListView list_view_main;
    public String[] dayName={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view_main=(ListView)findViewById(R.id.list_view_main);
        final MainListAdapter adapter=new MainListAdapter(this,dayName);
        adapter.setParentListView(list_view_main);
        list_view_main.setAdapter(adapter);
        list_view_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((FoldingCell) view).toggle(false);
                adapter.registerToggle(i);
            }
        });

    }

}
