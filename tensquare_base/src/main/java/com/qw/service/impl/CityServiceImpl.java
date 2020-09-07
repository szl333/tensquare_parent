package com.qw.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.Result;
import com.entity.StatusCode;
import com.qw.dao.CityDao;
import com.qw.pojo.City;
import com.qw.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
