package com.quan.demo.bookstore.annotation;

import com.quan.demo.bookstore.annotation.validator.CheckLanguageTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
// TODO
// 注解作用,约束注解指定约束校验器
@Constraint(validatedBy = CheckLanguageTypeValidator.class)
public @interface CheckLanguageType {

    String message() default "enum illegal!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends Enum<?>> enumClass();

    String enumMethod() default "";
}
