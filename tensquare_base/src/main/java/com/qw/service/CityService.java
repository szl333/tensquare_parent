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

    Result deleteById(String id);

    Result findById(String id);

    Result search(City city);

    Result searchByPage(Integer page, Integer size, City city);
}
