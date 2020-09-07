package com.qw.controller;

import com.entity.Result;
import com.qw.pojo.City;
import com.qw.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author Arkay
 * @Date 2020/9/7 15:54
 * @Version 1.0
 */
@RestController
@RequestMapping("city")
@CrossOrigin
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public Result findAll() {
        return cityService.findAll();
    }

    @PostMapping
    public Result addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @PutMapping("/{cityId}")
    public Result updateCity(@PathVariable("cityId") String id,
                             @RequestBody City city) {
        return cityService.updateCity(id, city);
    }
}
