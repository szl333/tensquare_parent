package com.qw.controller;

import com.entity.Result;
import com.qw.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Author Arkay
 * @Date 2020/9/7 15:54
 * @Version 1.0
 */
@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public Result findAll() {
        return cityService.findAll();
    }
}
