package com.example.application.ui.type;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application.R;
import com.example.application.mvp.main.bean.QuestionBean;
import com.example.application.mvp.main.presenter.impl.QuestionPresenter;
import com.example.application.mvp.main.view.QuestionView;
import com.example.application.ui.base.MvpActivity;

import java.util.List;


public class SingleActivity extends MvpActivity<QuestionPresenter> implements QuestionView {

    private String levelName;
    private String typeName;
    private TextView single_question_type;
    private TextView single_question_title;
    private TextView single_select_one;
    private TextView single_select_two;
    private TextView single_select_three;
    private TextView single_select_four;
    private TextView single_number;
    private ImageView single_collect;
    private List<QuestionBean> mQuestionBeans;
    private int mCount = 0;
    private int mPoint = 1;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            single_question_title.setText("        " + mQuestionBeans.get(mCount).getQuestionContent());
            single_select_one.setText("A:  " + mQuestionBeans.get(msg.arg1).getQuestionOne());
            single_select_two.setText("B:  " + mQuestionBeans.get(msg.arg1).getQuestionTwo());
            single_select_three.setText("C:  " + mQuestionBeans.get(msg.arg1).getQuestionThree());
            single_select_four.setText("D:  " + mQuestionBeans.get(msg.arg1).getQuestionFour());
            single_select_one.setBackgroundColor(Color.WHITE);
            single_select_two.setBackgroundColor(Color.WHITE);
            single_select_three.setBackgroundColor(Color.WHITE);
            single_select_four.setBackgroundColor(Color.WHITE);
            single_collect.setImageResource(R.drawable.ic_single_unstar);
            single_number.setText((mCount + 1)+ "/" + mQuestionBeans.size());
        }
    };


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.single_back:
                if(mCount > 1) {
                    mCount = mCount - 1;
                    Message messageBack = mHandler.obtainMessage();
                    messageBack.arg1 = mCount;
                    mHandler.sendMessage(messageBack);
                } else {
                    toastShow("这是第一题");
                }

                break;
            case R.id.single_collect:
                break;
            case R.id.single_forward:
                if(mCount < mQuestionBeans.size()) {
                    mCount = mCount + 1;
                    Message messageForward = mHandler.obtainMessage();
                    messageForward.arg1 = mCount;
                    mHandler.sendMessage(messageForward);
                } else {
                    toastShow("这是最后一道题");
                }
                break;
            case R.id.single_select_one:
                single_select_one.setBackgroundColor(Color.parseColor("#00574B"));
                single_select_two.setBackgroundColor(Color.WHITE);
                single_select_three.setBackgroundColor(Color.WHITE);
                single_select_four.setBackgroundColor(Color.WHITE);
                break;
            case R.id.single_select_two:
                single_select_two.setBackgroundColor(Color.parseColor("#00574B"));
                single_select_one.setBackgroundColor(Color.WHITE);
                single_select_three.setBackgroundColor(Color.WHITE);
                single_select_four.setBackgroundColor(Color.WHITE);
                break;
            case R.id.single_select_three:
                single_select_three.setBackgroundColor(Color.parseColor("#00574B"));
                single_select_one.setBackgroundColor(Color.WHITE);
                single_select_two.setBackgroundColor(Color.WHITE);
                single_select_four.setBackgroundColor(Color.WHITE);
                break;
            case R.id.single_select_four:
                single_select_four.setBackgroundColor(Color.parseColor("#00574B"));
                single_select_one.setBackgroundColor(Color.WHITE);
                single_select_two.setBackgroundColor(Color.WHITE);
                single_select_three.setBackgroundColor(Color.WHITE);
                break;
            case R.id.single_relativeLayout_collect:
                if(mPoint > 0) {
                    single_collect.setImageResource(R.drawable.ic_single_star);
                    mPoint = mPoint - 1;
                    //TODO 取的数据保存到数据库中
                } else {
                    single_collect.setImageResource(R.drawable.ic_single_unstar);
                    mPoint = mPoint + 1;
                }
                break;
            case R.id.single_submit:
                //TODO 拿到答案保存到数组中 到最后显示对错答案
                if(mCount < mQuestionBeans.size()) {
                    mCount = mCount + 1;
                    Message messageSubmit = mHandler.obtainMessage();
                    messageSubmit.arg1 = mCount;
                    mHandler.sendMessage(messageSubmit);
                } else {
                    //TODO 显示一个Dialog 用来提醒用户是否到了最后一道题 还要判断改题该用户答了没有 答了就选择下一题 没答 就空开
                    toastShow("这是最后一道题,");
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 继承了 MvpActivity中的BaseActivity
         */
        setContentView(R.layout.activity_single);
        levelName = getIntent().getStringExtra("level");
        typeName = getIntent().getStringExtra("type");
        /**
         * 加载布局
         */
        initView();
        /**
         * 加载数据
         */
        initData(levelName, typeName);


    }

    private void initData(final String levelName, final String typeName) {
        /**
         * 制造延迟加载效果
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mvpPresenter.loadData(levelName, typeName);
            }
        }, 1000);
    }

    @Override
    protected QuestionPresenter createPresenter() {
        return  new QuestionPresenter(this);
    }

    private void initView() {
        single_question_type = findViewById(R.id.single_question_type);
        single_question_type.setText("题型:    " + typeName);
        single_question_title = findViewById(R.id.single_question_title);
        single_select_one = findViewById(R.id.single_select_one);
        single_select_two = findViewById(R.id.single_select_two);
        single_select_three = findViewById(R.id.single_select_three);
        single_select_four = findViewById(R.id.single_select_four);
        single_number = findViewById(R.id.single_number);
        single_collect = findViewById(R.id.single_collect);

    }

    @Override
    public void getDataSuccess(List<QuestionBean> questionBeans) {
        this.mQuestionBeans = questionBeans;

        single_question_title.setText("        " + mQuestionBeans.get(mCount).getQuestionContent());
        single_select_one.setText("A:  " + mQuestionBeans.get(mCount).getQuestionOne());
        single_select_two.setText("B:  " + mQuestionBeans.get(mCount).getQuestionTwo());
        single_select_three.setText("C:  " + mQuestionBeans.get(mCount).getQuestionThree());
        single_select_four.setText("D:  " + mQuestionBeans.get(mCount).getQuestionFour());
        single_number.setText((mCount + 1)+ "/" + mQuestionBeans.size());
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
        mvpPresenter.detachView();
        super.onDestroy();
    }
}