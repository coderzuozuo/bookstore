package com.quan.demo.bookstore.aop;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义一个切面, 统一处理返回结果
 *
 * @author z00454779
 * @since 2020-04-14
 */

@Aspect
@Component
@Slf4j
public class HandleRespAspect {

    // @Around("execution(* com.quan.demo.bookstore.controller.*Controller.*(..))")
    @Around("execution(* com.quan.demo.bookstore.controller.HealthController.HealthCheck2(..))")
    public  Object handler(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return processResultAddCodeAndMessage(pjp);
        } catch (Exception e) {
            log.error("Aspect handle error: ", e);
            throw e;
        }
    }


    private Object processResultAddCodeAndMessage(ProceedingJoinPoint pjp) throws Throwable {
        Object object;
        Map<String, Object> map = new HashMap<>();

        // 前置通知
        log.info("before advice: {} begin run", pjp.getSignature().getName());
        log.info("class_method: {}.{}", pjp.getSignature().getDeclaringTypeName(),pjp.getSignature().getName());

        try {
            object = pjp.proceed();
            map.put("code","0");
            map.put("msg", "success");
            map.put("result",object);
            ResponseEntity resp = new ResponseEntity(map, HttpStatus.OK);
            // 返回通知
            return resp;
        } catch (Exception e) {
            // 异常通知
            map.put("code","0");
            map.put("msg", "error");
            map.put("result",e.getMessage());
            log.error("process error:",e);
            throw e;
        } finally {
            // 后置通知
        }
    }

}
