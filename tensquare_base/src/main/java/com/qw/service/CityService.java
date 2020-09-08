package com.qw.service;


import com.entity.Result;
import com.github.pagehelper.PageInfo;
import com.qw.pojo.City;

import java.util.List;

/**
 * @Author Arkay
 * @Date 2020/9/7 15:57
 * @Version 1.0
 */
public interface CityService {
    List<City> findAll();

    City addCity(City city);

    City updateCity(String id, City city);

    void deleteById(String id);

    City findById(String id);

    List<City> search(City city);

    PageInfo searchByPage(Integer page, Integer size, City city);
}
