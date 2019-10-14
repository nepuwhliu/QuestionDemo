package com.example.application.mvp.main.model;

import com.example.application.http.ApiClient;
import com.example.application.http.RetrofitCallback;
import com.example.application.http.api.ApiStores;
import com.example.application.mvp.main.bean.UserBean;
import com.example.application.mvp.main.presenter.IUserPresenter;


import retrofit2.Call;

public class UserModel {

    IUserPresenter mIUserPresenter;
    public UserModel(IUserPresenter iUserPresenter) {
        this.mIUserPresenter = iUserPresenter;
    }

    /**
     * 访问网络层 拿到链接的题目
     */
    public void loadData(final String username, String password) {

        Call<UserBean> call = apiStores().userLogin(username, password);
        call.enqueue(new RetrofitCallback<UserBean>() {
            /**
             * 拿到题目数据
             * @param userBean
             */
            @Override
            public void onSuccess(UserBean userBean) {
                /**
                 * 请求成功
                 */
                mIUserPresenter.loadDataSuccess(userBean);
            }
            @Override
            public void onFailure(int code, String msg) {
                /**
                 * 请求失败
                 */
                mIUserPresenter.loadDataFailure("失败代码:" + code + ", 原因:" + msg);
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