package com.quan.demo.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bookstore/v1")
public class Health {
    /**
     * 健康检查接口
     *
     * @return 健康状态
     */
    @RequestMapping(path = "/health", method = RequestMethod.GET)
    public String HealthCheck() {
        return "status is up!";
    }
}
