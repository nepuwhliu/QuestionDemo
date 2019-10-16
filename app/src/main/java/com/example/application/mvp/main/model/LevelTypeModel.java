package com.example.application.mvp.main.model;

import com.example.application.http.ApiClient;
import com.example.application.http.RetrofitCallback;
import com.example.application.http.api.ApiStores;
import com.example.application.mvp.main.bean.LevelTypeBean;
import com.example.application.mvp.main.presenter.ILevelTypePresenter;

import java.util.List;

import retrofit2.Call;

public class LevelTypeModel {

    private ILevelTypePresenter mILevelTypePresenter;
    public LevelTypeModel(ILevelTypePresenter iLevelTypePresenter) {
        this.mILevelTypePresenter = iLevelTypePresenter;
    }

    /**
     * 访问网络层 拿到链接的题目
     */
    public void loadData() {

        Call<List<LevelTypeBean>> call = apiStores().getQuestionLevelType();
        call.enqueue(new RetrofitCallback<List<LevelTypeBean>>() {
            /**
             * 拿到题目数据
             * @param levelTypeBeans
             */
            @Override
            public void onSuccess(List<LevelTypeBean> levelTypeBeans) {
                /**
                 * 请求成功
                 */
                mILevelTypePresenter.loadLevelTypeDataSuccess(levelTypeBeans);
            }
            @Override
            public void onFailure(int code, String msg) {
                /**
                 * 请求失败
                 */
                mILevelTypePresenter.loadLevelTypeDataFailure("失败代码:" + code + ", 原因:" + msg);
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
