package com.example.application.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.example.application.R;
import com.example.application.mvp.main.bean.QuestionBean;
import com.example.application.mvp.main.presenter.impl.QuestionPresenter;
import com.example.application.mvp.main.view.QuestionView;
import com.example.application.ui.base.MvpActivity;
import java.util.List;


public class QuestionActivity extends MvpActivity<QuestionPresenter> implements QuestionView {


    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 继承了 MvpActivity中的BaseActivity
         */
        setContentView(R.layout.activity_login);
        /**
         * 加载布局
         */
        initView();
        /**
         * 加载数据
         */
        initData();
    }

    private void initData() {
        /**
         * 制造延迟加载效果
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mvpPresenter.loadData();
            }
        }, 2000);
    }

    @Override
    protected QuestionPresenter createPresenter() {
        return  new QuestionPresenter(this);
    }

    private void initView() {

        text = findViewById(R.id.text);
    }


    @Override
    public void getDataSuccess(List<QuestionBean> questionBeans) {
        text.setText(questionBeans.get(0).getQuestionContent());
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