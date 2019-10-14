package com.example.application.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.application.R;
import com.example.application.mvp.main.bean.UserBean;
import com.example.application.mvp.main.presenter.impl.UserPresenter;
import com.example.application.mvp.main.view.UserView;
import com.example.application.ui.base.MvpActivity;
import com.example.application.utils.MD5Utils;

public class LoginActivity extends MvpActivity<UserPresenter> implements UserView {

    /**
     * 控件
     */
    private EditText login_user_name;
    private EditText login_password;

    /**
     * 变量
     */
    private String username;
    private String password;
    private String md5Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 继承了 MvpActivity中的BaseActivity
         */
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        /**
         * 加载布局
         */
        initView();
    }

    private void initData() {

        mvpPresenter.loadData(username, md5Password);

    }

    private void initView() {
        login_user_name = findViewById(R.id.login_user_name);
        login_password = findViewById(R.id.login_password);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_login:
                //获取用户名
                username = login_user_name.getText().toString().trim();
                //获取密码
                password = login_password.getText().toString().trim();
                //对当前的密码进行md5加密
                md5Password = MD5Utils.md5(password);
                initData();
                if(TextUtils.isEmpty(username)) {
                    toastShow("请输入用户名");
                } else if(TextUtils.isEmpty(password)) {
                    toastShow("请输入密码");
                } else if ( readMd5Password(username) != null ) {
                    /**
                     * 登录成功 关闭页面跳转到主页面
                     */
                    startActivity(new Intent(mActivity, IndexActivity.class));
                    mActivity.finish();
                } else if((md5Password != null && !TextUtils.isEmpty(md5Password)) && (username != null && !TextUtils.isEmpty(username))) {
                    toastShow("输入的用户名和密码不一致");
                } else {
                    toastShow("此用户名不存在");
                }
                break;
            case R.id.login_register:
                Intent intent = new Intent(mActivity, RegisterActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.login_find_password:
                startActivity(new Intent(mActivity, FindPasswordActivity.class));
                break;
        }
    }

    /**
     * 得到用户的加密之后的密码
     * 如果是注册就直接从SharedPreferences中取密码
     * 否则查询数据库 从数据库中根据用户名拿到对应的密码
     * @param msg
     * @return
     */
    private String readMd5Password(String msg) {
        SharedPreferences userSharePreferences = getSharedPreferences("userBean", MODE_PRIVATE);
        String username = userSharePreferences.getString("username", "");
        if(username.equals(msg)) {
            return userSharePreferences.getString("md5Password", "");
        }
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

    @Override
    protected UserPresenter createPresenter() {
        return new UserPresenter(this);
    }

    @Override
    public void getDataSuccess(UserBean userBean) {
        /**
         * 保存到SharedPreferences中
         */
        SharedPreferences userSharedPreferences = getSharedPreferences("userBean", MODE_PRIVATE);
        SharedPreferences.Editor userEditor = userSharedPreferences.edit();
        userEditor.putString("username", userBean.getUsername());
        userEditor.putString("md5Password", userBean.getPassword());
        userEditor.apply();
    }

    @Override
    public void getDataFail(String msg) {
        toastShow(msg);
    }

    @Override
    protected void onDestroy() {
        mvpPresenter.detachView();
        super.onDestroy();
    }
}
