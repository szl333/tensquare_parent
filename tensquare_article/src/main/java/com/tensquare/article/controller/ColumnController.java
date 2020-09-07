package com.tensquare.article.controller;

import com.tensquare.article.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ligangan
 * @Date: 2020/9/7
 * @Time: 17:55
 */
@RestController
@RequestMapping("column")
public class ColumnController {
    @Autowired
    private ColumnService columnService;


}








