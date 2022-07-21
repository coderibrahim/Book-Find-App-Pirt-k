package com.iakbas.pirtuk.Dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.iakbas.pirtuk.Dao.Impl.BookDatabaseImpl;
import com.iakbas.pirtuk.Entity.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {

    public abstract BookDatabaseImpl bookDatabase();

    private static BookDatabase INSTANCE;

    public static BookDatabase getDbInstance(Context context){


        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BookDatabase.class,"BookDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;

    }



}
