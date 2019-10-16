package com.example.application.mvp.main.view;

import com.example.application.mvp.main.bean.QuestionTypeBean;

import java.util.List;

public interface QuestionTypeView {

    /**
     * 获取数据成功
     * @param questionTypeBeans
     */
    void getQuestionTypeDataSuccess(List<QuestionTypeBean> questionTypeBeans);

    /**
     * 获取数据失败
     * @param msg
     */
    void getQuestionTypeDataFail(String msg);
}
