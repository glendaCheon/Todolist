package com.example.todolist.main;

import com.example.todolist.base.BasePresenterImpl;
import com.example.todolist.logic.Repository;
import com.example.todolist.logic.RepositoryImpl;
import com.example.todolist.model.Item;

import java.util.List;

public class MainPresenter
        extends BasePresenterImpl<MainContract.View>
        implements MainContract.Presenter {
    Repository repository;

    MainPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void fetchItems() {
        this.repository.fetchItems();

    }

    @Override
    public void fetchItemsDone(List<Item> items) {
        view.fetchItemsDone(items);
    }

    @Override
    public void showDetail(int pos) {
        view.showDetail(pos);
    }
}
