package com.example.todolist.logic.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.todolist.model.Item;

import java.util.List;

@Dao
public interface ItemDao {
    // TODO Query, Insert, Update
    // Query list
    @Query("select * from item order by no desc")
    List<Item> fetchItems();

    // Update

    // Insert
    @Insert
    void saveItem(Item item);
}
