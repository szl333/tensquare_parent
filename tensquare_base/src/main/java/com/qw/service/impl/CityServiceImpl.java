package com.qw.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.entity.PageResult;
import com.entity.Result;
import com.entity.StatusCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qw.dao.CityDao;
import com.qw.pojo.City;
import com.qw.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Arkay
 * @Date 2020/9/7 15:59
 * @Version 1.0
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Override
    public Result findAll() {
        Result result = new Result();
        result.setData(cityDao.selectList(null));
        result.setCode(StatusCode.OK);
        result.setFlag(true);
        result.setMessage("success");
        return result;
    }

    @Override
    public Result addCity(City city) {
        cityDao.insert(city);
        return new Result(true, StatusCode.OK, "success");
    }

    @Override
    public Result updateCity(String id, City city) {
        cityDao.updateById(city);
        return new Result(true, StatusCode.OK, "success");
    }

    @Override
    public Result deleteById(String id) {
        cityDao.deleteById(id);
        return new Result(true, StatusCode.OK, "success");
    }

    @Override
    public Result findById(String id) {
        City city = cityDao.selectById(id);
        return new Result(true, StatusCode.OK, "success", city);
    }

    @Override
    public Result search(City city) {
        List<City> cities = getCities(city);
        return new Result(true, StatusCode.OK, "success", cities);
    }

    @Override
    public Result searchByPage(Integer page, Integer size, City city) {
        PageHelper.startPage(page, size);
        List<City> cities = getCities(city);
        PageInfo<City> pageInfo = new PageInfo<>(cities);
        PageResult<City> cityPageResult = new PageResult<>();
        cityPageResult.setTotal(pageInfo.getTotal());
        cityPageResult.setRows(pageInfo.getList());

        return new Result(true, StatusCode.OK, "success", cityPageResult);
    }

    private List<City> getCities(City city) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("id", city.getId());
        queryWrapper.like("name", city.getName());
        queryWrapper.like("ishot", city.getIshot());
        return cityDao.selectList(queryWrapper);
    }
}
