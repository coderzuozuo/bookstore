package com.quan.demo.bookstore.annotation.validator;

import com.quan.demo.bookstore.annotation.CheckLanguageType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CheckLanguageTypeValidator implements ConstraintValidator<CheckLanguageType, String> {

    private Class<? extends Enum<?>> enumClass;

    private String enumMethod;

    @Override
    public void initialize(CheckLanguageType checkLanguageType) {
        enumClass = checkLanguageType.enumClass();
        enumMethod = checkLanguageType.enumMethod();
    }

    @Override
    public boolean isValid(String valueChecked, ConstraintValidatorContext constraintValidatorContext) {
        if (valueChecked == null) {
            return false;
        }
        if (enumClass == null || enumMethod == null) {
            return true;
        }

        try {
            Method method = enumClass.getMethod(enumMethod, valueChecked.getClass());
            // 第一个参数为该方法所属的对象，这里为静态方法，所以不属于任何对象，故为null
            Boolean result = (Boolean) method.invoke(null, valueChecked);
             return result == null ? false : result;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }
}
