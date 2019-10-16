package com.example.application.mvp.main.presenter.impl;

import android.os.Handler;
import android.os.Looper;
import android.provider.CalendarContract;

import com.example.application.mvp.main.bean.LevelBean;
import com.example.application.mvp.main.bean.LevelTypeBean;
import com.example.application.mvp.main.bean.QuestionTypeBean;
import com.example.application.mvp.main.model.LevelModel;
import com.example.application.mvp.main.model.LevelTypeModel;
import com.example.application.mvp.main.model.QuestionTypeModel;
import com.example.application.mvp.main.presenter.ILevelPresenter;
import com.example.application.mvp.main.presenter.ILevelTypePresenter;
import com.example.application.mvp.main.presenter.IQuestionTypePresenter;
import com.example.application.mvp.main.presenter.base.BasePresenter;
import com.example.application.mvp.main.view.IndexView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在这里做封装处理
 */
public class IndexPresenter implements BasePresenter<IndexView>, ILevelPresenter, ILevelTypePresenter, IQuestionTypePresenter {

    private LevelModel mLevelModel;
    private LevelTypeModel mLevelTypeModel;
    private QuestionTypeModel mQuestionTypeModel;

    public List<LevelBean> levelBeans = new ArrayList<>();
    public List<LevelTypeBean> levelTypeBeans = new ArrayList<>();
    public List<QuestionTypeBean> questionTypeBeans = new ArrayList<>();
    private IndexView mIndexView;

    public IndexPresenter(IndexView indexView) {
        attachView(indexView);
        mLevelModel = new LevelModel(this);
        mLevelTypeModel = new LevelTypeModel(this);
        mQuestionTypeModel = new QuestionTypeModel(this);


    }

    public void loadData() {

        /**
         * 显示加载栏
         */
        mIndexView.showLoading();
        /**
         * 加载数据
         */

        mLevelModel.loadData();
        mLevelTypeModel.loadData();
        mQuestionTypeModel.loadData();



    }

    public void combinationIndexViewData() {
        Map<String, String> map = new HashMap<>();
        //TODO
        for(int i = 0; i < levelTypeBeans.size(); ++i) {
            /**
             * 先拿类型 再拿题型
             */
            if(!map.containsKey(levelBeans.get(levelTypeBeans.get(i).getLevelId()).getLevelName())) {
                /**
                 * 如果不存在 存进去
                 */
                map.put(levelBeans.get(levelTypeBeans.get(i).getLevelId()).getLevelName(), questionTypeBeans.get(levelTypeBeans.get(i).getTypeId()).getQuestionType() + ",");
            } else {
                /**
                 * 通过当前的key 拿到对应的 值 然后组合
                 */
                String stringName = map.get(levelBeans.get(levelTypeBeans.get(i).getLevelId()).getLevelName());
                map.put(levelBeans.get(levelTypeBeans.get(i).getLevelId()).getLevelName(), stringName + questionTypeBeans.get(levelTypeBeans.get(i).getTypeId()).getQuestionType() + ",");
            }
        }
        mIndexView.getDataSuccess(map);
        mIndexView.hideLoading();
    }


    @Override
    public void loadLevelDataSuccess(List<LevelBean> levelBeans) {
        this.levelBeans = levelBeans;
    }

    @Override
    public void loadLevelDataFailure(String msg) {
        mIndexView.getDataFail(msg);
        mIndexView.hideLoading();
    }

    @Override
    public void loadLevelTypeDataSuccess(List<LevelTypeBean> levelTypeBeans) {
        this.levelTypeBeans = levelTypeBeans;
    }

    @Override
    public void loadLevelTypeDataFailure(String msg) {
        mIndexView.getDataFail(msg);
        mIndexView.hideLoading();
    }

    @Override
    public void loadQuestionTypeDataSuccess(List<QuestionTypeBean> questionTypeBeans) {
        this.questionTypeBeans = questionTypeBeans;
    }

    @Override
    public void loadQuestionTypeDataFailure(String msg) {
        mIndexView.getDataFail(msg);
        mIndexView.hideLoading();
    }

    @Override
    public void attachView(IndexView view) {
        this.mIndexView = view;
    }

    @Override
    public void detachView() {

        this.mIndexView = null;

    }
}
