package com.example.application.mvp.main.presenter;


import com.example.application.mvp.main.bean.QuestionTypeBean;

import java.util.List;

public interface IQuestionTypePresenter {
    /**
     * 数据加载成功
     * @param
     */
    void loadQuestionTypeDataSuccess(List<QuestionTypeBean> questionTypeBeans);

    /**
     * 数据加载失败
     */
    void loadQuestionTypeDataFailure(String msg);

}
