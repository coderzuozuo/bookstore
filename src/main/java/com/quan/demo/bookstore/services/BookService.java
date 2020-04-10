package com.quan.demo.bookstore.services;

import com.quan.demo.bookstore.domin.CreateBookReq;
import com.quan.demo.bookstore.entity.BookEntity;

public interface BookService {
    public BookEntity addBook(CreateBookReq createBookReq);
}
