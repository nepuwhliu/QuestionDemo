package com.example.application.mvp.main.model;

import com.example.application.http.ApiClient;
import com.example.application.http.RetrofitCallback;
import com.example.application.http.api.ApiStores;
import com.example.application.mvp.main.bean.QuestionBean;
import com.example.application.mvp.main.presenter.IQuestionPresenter;
import java.util.List;

import retrofit2.Call;

/**
 * Model层是用来获取数据的 访问网络连接层
 * 业务逻辑的具体处理， 包括负责存储、检索、操纵数据等
 * 在这里面要拿到Presenter层 把数据传到逻辑业务层
 */
public class QuestionModel {

    IQuestionPresenter mIQuestionPresenter;

    public QuestionModel(IQuestionPresenter iQuestionPresenter) {
        this.mIQuestionPresenter = iQuestionPresenter;
    }

    /**
     * 访问网络层 拿到链接的题目
     */
    public void loadData() {

        Call<List<QuestionBean>> call = apiStores().loadQuestionByRetrofit();
        call.enqueue(new RetrofitCallback<List<QuestionBean>>() {
            /**
             * 拿到题目数据
             * @param questionBeans
             */
            @Override
            public void onSuccess(List<QuestionBean> questionBeans) {
                /**
                 * 请求成功
                 */
                mIQuestionPresenter.loadDataSuccess(questionBeans);
            }
            @Override
            public void onFailure(int code, String msg) {
                /**
                 * 请求失败
                 */
                mIQuestionPresenter.loadDataFailure("失败代码:" + code + ", 原因:" + msg);
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
