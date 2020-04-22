package com.quan.demo.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bookstore/v1")
public class HealthController {
    /**
     * 健康检查接口
     *
     * @return 健康状态
     */
    @RequestMapping(path = "/health", method = RequestMethod.GET)
    public String HealthCheck() {
        return "status is up!";
    }

    @RequestMapping(path = "/health/v2", method = RequestMethod.GET)
    public ResponseEntity HealthCheck2() {
        return new ResponseEntity("status is up", HttpStatus.OK);
    }
}
