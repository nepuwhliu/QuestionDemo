package com.example.application.mvp.main.view;

import com.example.application.mvp.main.bean.UserBean;
import com.example.application.mvp.main.view.base.BaseView;


public interface UserView extends BaseView {
    /**
     * 获取数据成功
     * @param userBean
     */
    void getDataSuccess(UserBean userBean);

    /**
     * 获取数据失败
     * @param msg
     */
    void getDataFail(String msg);
}
