package com.example.application.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.application.Model;
import com.example.application.R;
import com.example.application.ui.adapter.SequenceAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 顺序题
 */
public class SequenceActivity extends Activity {

    private ExpandableListView expandableListView;

    private SequenceAdapter adapter;

    private List<Map<String, Object>> list;
    private String[][] child_text_array;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequence);

        init();
        initModle();
        setListener();
    }

    private void init() {
        expandableListView = findViewById(R.id.sequence_list);

        child_text_array = Model.EXPANDABLE_MORELIST_TXT;
    }

    private void setListener() {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(),
                        child_text_array[groupPosition][childPosition],
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void initModle() {
        list = new ArrayList<>();
        for (int i = 0; i < Model.EXPANDABLE_LISTVIEW_TXT.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("img", Model.EXPANDABLE_LISTVIEW_IMG[i]);
            map.put("txt", Model.EXPANDABLE_LISTVIEW_TXT[i]);
            list.add(map);
        }
        adapter = new SequenceAdapter(this, list, child_text_array);
        expandableListView.setAdapter(adapter);
    }

}
