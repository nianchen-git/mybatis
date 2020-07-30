package com.nc.mapper;

import com.nc.model.Author;
import com.nc.model.Book;

import java.util.List;

public interface BookMapper {
    Book getBookById(Integer id);
    Book getBookById2(Integer id);
    Author getAuthorById(Integer id);
    List<Book> queryAllBook();
}
