package com.quan.demo.bookstore.constant;

public enum Language {
    CHINESE("chinese"),
    ENGLISH("english"),
    OTHERS("others");

    // 成员变量
    private String value;

    // 构造方法
    private Language(String value) {
        this.value = value;
    }

    // 普通方法
    public String getValue() {
        return this.value;
    }

    // 判断enum是否包含值
    public static boolean containValue(String value) {
        for (Language language : Language.values()) {
            if (language.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
