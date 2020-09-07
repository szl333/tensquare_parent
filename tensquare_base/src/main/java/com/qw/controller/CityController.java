package com.qw.controller;

import com.entity.Result;
import com.github.pagehelper.PageHelper;
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

    /**
     * 查找所有城市
     * @return
     */
    @GetMapping
    public Result findAll() {
        return cityService.findAll();
    }

    /**
     * 添加城市
     * @param city
     * @return
     */
    @PostMapping
    public Result addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    /**
     * 修改城市
     * @param id
     * @param city
     * @return
     */
    @PutMapping("/{cityId}")
    public Result updateCity(@PathVariable("cityId") String id,
                             @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    /**
     * 删除城市
     * @param id
     * @return
     */
    @DeleteMapping("/{cityId}")
    public Result deleteCity(@PathVariable("cityId") String id) {
        return cityService.deleteById(id);
    }

    /**
     * 根据id查询城市
     */
    @GetMapping("/{cityId}")
    public Result findById(@PathVariable("cityId") String id) {
        return cityService.findById(id);
    }

    /**
     * 根据条件查询城市
     */
    @PostMapping("/search")
    public Result search(@RequestBody City city) {
        return cityService.search(city);
    }

    /**
     * 根据条件分页查询
     */
    @PostMapping("/search/{page}/{size}")
    public Result searchByPage(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size,
                               @RequestBody City city) {
        return cityService.searchByPage(page, size, city);
    }
}
