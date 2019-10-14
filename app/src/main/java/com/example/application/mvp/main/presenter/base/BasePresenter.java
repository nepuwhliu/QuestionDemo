package com.example.application.mvp.main.presenter.base;

/**
 * 这一层主要的是绑定视图和接触视图
 * @param <V>
 */
public interface BasePresenter<V> {
    /**
     * 绑定视图
     * @param view
     */
    void attachView(V view);

    /**
     * 解除视图
     */
    void detachView();
}
