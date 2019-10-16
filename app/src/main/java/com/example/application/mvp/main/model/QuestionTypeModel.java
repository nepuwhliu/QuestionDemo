package com.example.application.mvp.main.model;

import com.example.application.http.ApiClient;
import com.example.application.http.RetrofitCallback;
import com.example.application.http.api.ApiStores;
import com.example.application.mvp.main.bean.QuestionTypeBean;
import com.example.application.mvp.main.presenter.IQuestionTypePresenter;

import java.util.List;

import retrofit2.Call;

public class QuestionTypeModel {

    private IQuestionTypePresenter mIQuestionTypePresenter;
    public QuestionTypeModel(IQuestionTypePresenter iQuestionTypePresenter) {
        this.mIQuestionTypePresenter = iQuestionTypePresenter;
    }
    /**
     * 访问网络层 拿到链接的题目
     */
    public void loadData() {

        Call<List<QuestionTypeBean>> call = apiStores().getQuestionType();
        call.enqueue(new RetrofitCallback<List<QuestionTypeBean>>() {
            /**
             * 拿到题目数据
             * @param questionTypeBeans
             */
            @Override
            public void onSuccess(List<QuestionTypeBean> questionTypeBeans) {
                /**
                 * 请求成功
                 */
                mIQuestionTypePresenter.loadQuestionTypeDataSuccess(questionTypeBeans);
            }
            @Override
            public void onFailure(int code, String msg) {
                /**
                 * 请求失败
                 */
                mIQuestionTypePresenter.loadQuestionTypeDataFailure("失败代码:" + code + ", 原因:" + msg);
            }
            @Override
            public void onThrowable(Throwable t) {
                //getDataFail(t.getMessage());
            }
            @Override
            public void onFinish() {

            }
        });
    }

    /**
     * 拿到Api的对象
     * @return
     */
    public ApiStores apiStores() {
        return ApiClient.retrofit().create(ApiStores.class);
    }

}