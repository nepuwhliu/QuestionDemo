package com.example.application.mvp.main.presenter;


import com.example.application.mvp.main.bean.UserBean;

public interface IUserPresenter {
    /**
     * 数据加载成功
     * @param
     */
    void loadDataSuccess(UserBean userBean);

    /**
     * 数据加载失败
     */
    void loadDataFailure(String msg);

}
