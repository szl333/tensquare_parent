package com.qw.controller;

import com.entity.PageResult;
import com.entity.Result;
import com.entity.StatusCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        return new Result(true, StatusCode.OK, "success", cityService.findAll());
    }

    /**
     * 添加城市
     * @param city
     * @return
     */
    @PostMapping
    public Result addCity(@RequestBody City city) {
        cityService.addCity(city);
        return new Result(true, StatusCode.OK, "success");
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
        cityService.updateCity(id, city);
        return new Result(true, StatusCode.OK, "success");
    }

    /**
     * 删除城市
     * @param id
     * @return
     */
    @DeleteMapping("/{cityId}")
    public Result deleteCity(@PathVariable("cityId") String id) {
        cityService.deleteById(id);
        return new Result(true, StatusCode.OK, "success");
    }

    /**
     * 根据id查询城市
     */
    @GetMapping("/{cityId}")
    public Result findById(@PathVariable("cityId") String id) {
        return new Result(true, StatusCode.OK, "success", cityService.findById(id));
    }

    /**
     * 根据条件查询城市
     */
    @PostMapping("/search")
    public Result search(@RequestBody City city) {
        return  new Result(true, StatusCode.OK, "success", cityService.search(city));
    }

    /**
     * 根据条件分页查询
     */
    @PostMapping("/search/{page}/{size}")
    public Result searchByPage(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size,
                               @RequestBody City city) {
        PageInfo pageInfo = cityService.searchByPage(page, size, city);
        PageResult<City> pageResult = new PageResult<City>(pageInfo.getTotal(), pageInfo.getList());
        return new Result(true, StatusCode.OK, "success", pageResult);
    }
}
