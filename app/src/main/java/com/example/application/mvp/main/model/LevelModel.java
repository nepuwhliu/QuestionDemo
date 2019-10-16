package com.example.application.mvp.main.model;

import com.example.application.http.ApiClient;
import com.example.application.http.RetrofitCallback;
import com.example.application.http.api.ApiStores;
import com.example.application.mvp.main.bean.LevelBean;
import com.example.application.mvp.main.presenter.ILevelPresenter;

import java.util.List;

import retrofit2.Call;

public class LevelModel {

    private ILevelPresenter mILevelPresenter;
    public LevelModel(ILevelPresenter iLevelPresenter) {
        this.mILevelPresenter = iLevelPresenter;
    }


    /**
     * 访问网络层 拿到链接的题目
     */
    public void loadData() {

        Call<List<LevelBean>> call = apiStores().getQuestionLevel();
        call.enqueue(new RetrofitCallback<List<LevelBean>>() {
            /**
             * 拿到等级
             * @param levelBeans
             */
            @Override
            public void onSuccess(List<LevelBean> levelBeans) {
                /**
                 * 请求成功
                 */
                mILevelPresenter.loadLevelDataSuccess(levelBeans);
            }
            @Override
            public void onFailure(int code, String msg) {
                /**
                 * 请求失败
                 */
                mILevelPresenter.loadLevelDataFailure("失败代码:" + code + ", 原因:" + msg);
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