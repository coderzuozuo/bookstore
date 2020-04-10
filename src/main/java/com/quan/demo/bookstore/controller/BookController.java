package com.quan.demo.bookstore.controller;

import com.alibaba.fastjson.JSON;
import com.quan.demo.bookstore.domin.CreateBookReq;
import com.quan.demo.bookstore.entity.BookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/bookstore/v1")
public class BookController {

    @RequestMapping(path = "/book", method = RequestMethod.POST)
    public BookEntity addBook(@RequestBody @Valid CreateBookReq req) {
        String bookInfo = JSON.toJSONString(req);
        System.out.println("CreateBookReq: "+ bookInfo);

        BookEntity book = new BookEntity();
        BeanUtils.copyProperties(req, book);

        return book;
    }
}
