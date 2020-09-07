package com.qw.service;


import com.entity.Result;
import com.qw.pojo.City;

/**
 * @Author Arkay
 * @Date 2020/9/7 15:57
 * @Version 1.0
 */
public interface CityService {
    Result findAll();

    Result addCity(City city);

    Result updateCity(String id, City city);
}
