package com.tensquare.article.controller;

import com.entity.Result;
import com.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: ligangan
 * @Date: 2020/9/5
 * @Time: 11:08
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handler (Exception e) {
        System.out.println("处理异常");
        return new Result()
                .setMessage(e.getMessage())
                .setFlag(false)
                .setCode(StatusCode.ERROR);
    }
}
