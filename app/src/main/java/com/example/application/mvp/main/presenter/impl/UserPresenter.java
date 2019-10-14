package com.example.application.mvp.main.presenter.impl;

import com.example.application.mvp.main.bean.UserBean;
import com.example.application.mvp.main.model.UserModel;
import com.example.application.mvp.main.presenter.IUserPresenter;
import com.example.application.mvp.main.presenter.base.BasePresenter;
import com.example.application.mvp.main.view.UserView;

public class UserPresenter implements BasePresenter<UserView>, IUserPresenter {
    private UserView mUserView;
    private UserModel mUserModel;

    public UserPresenter(UserView userView){

        attachView(userView);
        mUserModel = new UserModel(this);
    }
    public void loadData(String username, String password) {
        System.out.println("加载数据");
        /**
         * 显示加载栏
          */
        mUserView.showLoading();
        /**
         * 加载数据
         */
        mUserModel.loadData(username, password);
    }
    @Override
    public void attachView(UserView view) {
        this.mUserView = view;
    }

    @Override
    public void detachView() {
        this.mUserView = null;
    }

    /**
     * 把数据传到Presenter层 进行处理
     */
    @Override
    public void loadDataSuccess(UserBean userBean) {
        mUserView.getDataSuccess(userBean);
        mUserView.hideLoading();
    }

    @Override
    public void loadDataFailure(String msg) {
        mUserView.getDataFail(msg);
        mUserView.hideLoading();
    }
}
