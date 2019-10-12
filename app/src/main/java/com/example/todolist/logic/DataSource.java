package com.example.todolist.logic;

import com.example.todolist.model.Item;

public interface DataSource {
    void setRepository(Repository repository);
    void save(Item item);

    void fetchItems();
}
