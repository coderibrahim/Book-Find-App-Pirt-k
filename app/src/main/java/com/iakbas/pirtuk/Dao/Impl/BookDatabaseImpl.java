package com.iakbas.pirtuk.Dao.Impl;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.iakbas.pirtuk.Entity.Book;
import com.iakbas.pirtuk.Model.Item;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface BookDatabaseImpl {


    @Query("SELECT * FROM book")
    public List<Book> getAllBooks();

    @Insert
    public void createBook(Book book);

    @Delete
    public void deleteBook(Book book);


}
