package com.iakbas.pirtuk.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Book")
public class Book {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int bookId;

    @ColumnInfo(name = "title")
    public String bookTitle;

    @ColumnInfo(name = "subTitle")
    public String bookSubTitle;

    @ColumnInfo(name = "image")
    public String bookImage;

    @ColumnInfo(name = "author")
    public String bookAuthor;

    @ColumnInfo(name = "description")
    public String description;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookSubTitle() {
        return bookSubTitle;
    }

    public void setBookSubTitle(String bookSubTitle) {
        this.bookSubTitle = bookSubTitle;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
