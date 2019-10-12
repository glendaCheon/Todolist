package com.example.todolist.logic.local;

import android.os.AsyncTask;
import android.util.Log;

import com.example.todolist.logic.DataSource;
import com.example.todolist.logic.Repository;
import com.example.todolist.model.Item;

import java.util.List;

public class LocalDataSourceImpl implements DataSource {
    Repository repository;
    AppDatabase appDatabase;

    public LocalDataSourceImpl() {
        try {
            appDatabase = AppDatabaseProvider.getINSTANCE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void save(final Item item) {
        //TODO SAVE

        try {

            new AsyncTask<Void, Void, Void>(

            ) {
                // 백그라운드 동작
                @Override
                protected Void doInBackground(Void... voids) {
                    ItemDao itemDao = appDatabase.getItemDao();
                    itemDao.saveItem(item);
                    return null;
                }

                //UI 쓰레드 동작
                @Override
                protected void onPostExecute(Void aVoid) {
                    repository.saveDone();
                }
            }.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Fetch Items
    @Override
    public void fetchItems() {
        new Thread(() -> {
            List<Item> items = appDatabase.getItemDao().fetchItems();
            Log.d("Data", items.size() + "");
            repository.fetchItemsDone(items);
        }).start();
    }
}
