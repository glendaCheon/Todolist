package com.example.todolist.base;

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    protected T view;

    @Override
    public void setView(T view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }
}
