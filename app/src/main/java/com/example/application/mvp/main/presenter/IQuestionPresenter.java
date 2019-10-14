package com.example.application.mvp.main.presenter;


import com.example.application.mvp.main.bean.QuestionBean;

import java.util.List;

/**
 * 此接口的作用是用来连接Model的
 */
public interface IQuestionPresenter {
    /**
     * 数据加载成功
     * @param questionBeanList
     */
    void loadDataSuccess(List<QuestionBean> questionBeanList);

    /**
     * 数据加载失败
     */
    void loadDataFailure(String msg);
}
