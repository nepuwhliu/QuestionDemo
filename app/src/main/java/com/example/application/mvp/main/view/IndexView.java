package com.example.application.mvp.main.view;

import com.example.application.mvp.main.view.base.BaseView;

import java.util.Map;

/**
 * 封装三层数据
 */
public interface IndexView extends BaseView {
    /**
     * 在这里做数据封装
     * @param map
     */
    void getDataSuccess(Map<String, String> map);

    /**
     * 获取数据失败
     * @param msg
     */
    void getDataFail(String msg);
}
