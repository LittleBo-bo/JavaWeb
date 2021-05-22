package com.cb.service;

import com.cb.dao.BookMapper;
import com.cb.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public int insert(Books books) {
        return bookMapper.insert(books);
    }

    @Override
    public int delete(int id) {
        return bookMapper.delete(id);
    }

    @Override
    public int update(Books books) {
        return bookMapper.update(books);
    }

    @Override
    public Books queryById(int id) {
        return bookMapper.queryById(id);
    }

    @Override
    public List<Books> queryMoHu(String bookName) {
        return bookMapper.queryMoHu(bookName);
    }
}
