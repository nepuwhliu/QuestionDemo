package com.example.application.mvp.main.view;

import com.example.application.mvp.main.bean.LevelBean;

import java.util.List;

public interface LevelView {
    /**
     * 获取数据成功
     * @param levelBeans
     */
    void getLevelDataSuccess(List<LevelBean> levelBeans);

    /**
     * 获取数据失败
     * @param msg
     */
    void getLevelDataFail(String msg);
}
