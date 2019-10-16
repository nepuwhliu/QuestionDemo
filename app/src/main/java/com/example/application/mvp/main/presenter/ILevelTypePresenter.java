package com.example.application.mvp.main.presenter;

import com.example.application.mvp.main.bean.LevelTypeBean;

import java.util.List;

public interface ILevelTypePresenter {
    /**
     * 数据加载成功
     * @param
     */
    void loadLevelTypeDataSuccess(List<LevelTypeBean> levelTypeBeans);

    /**
     * 数据加载失败
     */
    void loadLevelTypeDataFailure(String msg);
}
