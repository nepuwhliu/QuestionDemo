package com.example.application.mvp.main.presenter.impl;

import com.example.application.mvp.main.bean.QuestionBean;
import com.example.application.mvp.main.model.QuestionModel;
import com.example.application.mvp.main.presenter.IQuestionPresenter;
import com.example.application.mvp.main.presenter.base.BasePresenter;
import com.example.application.mvp.main.view.QuestionView;

import java.util.List;


/**
 * View 和 Model 的桥梁, 他从Model层检索数据口 返回到 View层
 */
public class QuestionPresenter implements BasePresenter<QuestionView>, IQuestionPresenter {

    private QuestionView mQuestionView;
    private QuestionModel mQuestionModel;

    public QuestionPresenter(QuestionView questionView){
        attachView(questionView);
        mQuestionModel = new QuestionModel(this);
    }

    /**
     * 加载数据 显示加载栏
     */
    public void loadData(String levelName, String typeName) {
        /**
         * 显示加载栏
         */
        mQuestionView.showLoading();
        /**
         * 加载数据
         */
        mQuestionModel.loadDataByCondition(levelName, typeName);
    }
    @Override
    public void loadDataSuccess(List<QuestionBean> questionBeans) {
        /**
         * view 拿到数据
         */
        mQuestionView.getDataSuccess(questionBeans);
        mQuestionView.hideLoading();
    }

    @Override
    public void loadDataFailure(String msg) {
        mQuestionView.getDataFail(msg);
        mQuestionView.hideLoading();
    }

    /**
     * 关联视图
     * @param view
     */
    @Override
    public void attachView(QuestionView view) {
        this.mQuestionView = view;
    }

    /**
     * 取消关联视图
     */
    @Override
    public void detachView() {
        this.mQuestionView = null;
    }
}
