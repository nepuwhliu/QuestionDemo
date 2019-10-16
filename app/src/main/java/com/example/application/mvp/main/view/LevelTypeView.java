package com.example.application.mvp.main.view;

import com.example.application.mvp.main.bean.LevelTypeBean;

import java.util.List;

public interface LevelTypeView {
    /**
     * 获取数据成功
     * @param levelTypeBeans
     */
    void getLevelTypeDataSuccess(List<LevelTypeBean> levelTypeBeans);

    /**
     * 获取数据失败
     * @param msg
     */
    void getLevelTypeDataFail(String msg);
}
