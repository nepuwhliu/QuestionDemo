package com.example.application.mvp.main.view;

import com.example.application.mvp.main.bean.QuestionBean;
import com.example.application.mvp.main.view.base.BaseView;

import java.util.List;

/**
 * view 用来获取model层的数据 用来调用Model层
 */
public interface QuestionView extends BaseView {

    /**
     * 获取数据成功
     * @param questionBeans
     */
    void getDataSuccess(List<QuestionBean> questionBeans);

    /**
     * 获取数据失败
     * @param msg
     */
    void getDataFail(String msg);

}
