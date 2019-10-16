package com.example.application.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.application.Model;
import com.example.application.R;
import com.example.application.mvp.main.presenter.impl.IndexPresenter;
import com.example.application.mvp.main.view.IndexView;
import com.example.application.ui.adapter.SequenceAdapter;
import com.example.application.ui.base.MvpActivity;
import com.example.application.ui.type.JudgeActivity;
import com.example.application.ui.type.MultipleActivity;
import com.example.application.ui.type.QuestionAndAnswerActivity;
import com.example.application.ui.type.SingleActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 顺序题
 */
public class SequenceActivity extends MvpActivity<IndexPresenter> implements IndexView {

    private Map<String, String> mMap = new HashMap<>();
    private ExpandableListView expandableListView;
    private SequenceAdapter adapter;
    private List<Map<String, Object>> list;
    private List<Object> mList = new ArrayList<>();
    private String[][] child_text_array = new String[10][]; //这里我们写死 以后改为动态的

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequence);
        init();



        mvpPresenter.loadData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mvpPresenter.combinationIndexViewData();
            }
        }, 2000);
        setListener();
    }

    @Override
    protected IndexPresenter createPresenter() {
        return new IndexPresenter(this);
    }

    private void init() {
        expandableListView = findViewById(R.id.sequence_list);

        child_text_array = Model.EXPANDABLE_MORELIST_TXT;
    }

    private void setListener() {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent,
                                        View v,
                                        int groupPosition,
                                        long id) {
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition,
                                        int childPosition,
                                        long id) {
//                Toast.makeText(getApplicationContext(),
//                        child_text_array[groupPosition][childPosition] + " " + mList.get(groupPosition),
//                        Toast.LENGTH_SHORT).show();
                /**
                 * 在这里判断需要跳转到那个题型的页面
                 */
                switch(child_text_array[groupPosition][childPosition]) {
                    case "单选题":
                        Intent intentSingle = new Intent();
                        intentSingle.putExtra("level", mList.get(groupPosition).toString());
                        intentSingle.putExtra("type", child_text_array[groupPosition][childPosition]);
                        intentSingle.setClass(mActivity, SingleActivity.class);
                        startActivity(intentSingle);
                        mActivity.finish();
                        break;
                    case "判断题":
                        Intent intentJudge = new Intent();
                        intentJudge.putExtra("level", mList.get(groupPosition).toString());
                        intentJudge.putExtra("type", child_text_array[groupPosition][childPosition]);
                        intentJudge.setClass(mActivity, JudgeActivity.class);
                        startActivity(intentJudge);
                        mActivity.finish();
                        break;
                    case "多选题":
                        Intent intentMultiple = new Intent();
                        intentMultiple.putExtra("level", mList.get(groupPosition).toString());
                        intentMultiple.putExtra("type", child_text_array[groupPosition][childPosition]);
                        intentMultiple.setClass(mActivity, MultipleActivity.class);
                        startActivity(intentMultiple);
                        mActivity.finish();
                        break;
                    case "填空题":
                        Intent intentQuestionAndAnswer = new Intent();
                        intentQuestionAndAnswer.putExtra("level", mList.get(groupPosition).toString());
                        intentQuestionAndAnswer.putExtra("type", child_text_array[groupPosition][childPosition]);
                        intentQuestionAndAnswer.setClass(mActivity, QuestionAndAnswerActivity.class);
                        startActivity(intentQuestionAndAnswer);
                        mActivity.finish();
                        break;
                }
                return true;
            }
        });
    }

    private void initModel() {
        int count = 0;
        list = new ArrayList<>();
        Set keys = mMap.keySet();
        if(keys != null) {

            Iterator iterator = keys.iterator();
            while( iterator.hasNext()) {
                Map<String, Object> map = new HashMap<>();
                Object key = iterator.next();
                map.put("img", Model.IMAGE[count]);
                map.put("txt", key);
                mList.add(key);
                /**
                 * 给二维数组赋值
                 */
                String value = mMap.get(key);
                String[] valueArr = value.split(",");
                child_text_array[count] = new String[valueArr.length];
                for(int i = 0; i < valueArr.length; ++i) {
                    child_text_array[count][i] = valueArr[i];
                }
                count = count + 1;
                list.add(map);
            }
        }
        adapter = new SequenceAdapter(this, list, child_text_array);
        expandableListView.setAdapter(adapter);
    }

    @Override
    public void getDataSuccess(Map<String, String> map) {
        this.mMap = map;
        initModel();
    }

    @Override
    public void getDataFail(String msg) {
        toastShow(msg);
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpPresenter.detachView();
    }

}
