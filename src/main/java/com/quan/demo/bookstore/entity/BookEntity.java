package com.quan.demo.bookstore.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookEntity {

    private String id;

    private String name;

    private String language;

    private String author;

    private int price;
}
