package com.example.application.ui.base;

import android.os.Bundle;

import com.example.application.mvp.main.presenter.base.BasePresenter;



public abstract class MvpActivity <P extends BasePresenter> extends BaseActivity {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    /**
     *  拿到数据逻辑层的对象
     * @return
     */
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

}
