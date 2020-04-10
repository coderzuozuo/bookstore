package com.quan.demo.bookstore.domin;

import com.quan.demo.bookstore.annotation.CheckLanguageType;
import com.quan.demo.bookstore.constant.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
public class CreateBookReq {
    private String name;

    @CheckLanguageType(message = "language type error", enumClass = Language.class, enumMethod = "containValue")
    private String language;

    private String author;

    @NotNull
    private int price;

    private Timestamp createTime;

    private String createUser;
}
