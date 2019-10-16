package com.example.application.mvp.main.presenter;

import com.example.application.mvp.main.bean.LevelBean;

import java.util.List;

public interface ILevelPresenter {
    /**
     * 数据加载成功
     * @param
     */
    void loadLevelDataSuccess(List<LevelBean> levelBeans);

    /**
     * 数据加载失败
     */
    void loadLevelDataFailure(String msg);
}
