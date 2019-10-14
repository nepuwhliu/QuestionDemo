package com.example.application.http;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitCallback<M> implements Callback<M> {

    /**
     * 加载成功执行该方法
     * @param model 泛型
     */
    public abstract void onSuccess(M model);

    /**
     * 加载失败
     * @param code 失败值
     * @param msg 异常信息
     */
    public abstract void onFailure(int code, String msg);

    /**
     * 异常
     * @param t
     */
    public abstract void onThrowable(Throwable t);

    /**
     * 结束请求
     */
    public abstract void onFinish();

    public void onResponse(Call<M> call, Response<M> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            onFailure(response.code(), response.errorBody().toString());
        }
        onFinish();
    }

    public void onFailure(Call<M> call, Throwable t) {
        onThrowable(t);
        onFinish();
    }
}
