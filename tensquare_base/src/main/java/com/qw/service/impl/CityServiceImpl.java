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
import com.qw.rabbitmq.DeleteCitySender;
import com.qw.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Arkay
 * @Date 2020/9/7 15:59
 * @Version 1.0
 */
@Service
@CacheConfig(cacheNames = "city")
public class CityServiceImpl implements CityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DeleteCitySender deleteCitySender;

    @Override
    @Cacheable(key = "#root.method.name")
    public List<City> findAll() {
        List<City> cities = cityDao.selectList(null);
        return cities;
    }

    @Override
    @Cacheable(key = "#city.getId()")
    public City addCity(City city) {
        cityDao.insert(city);
        return city;
    }

    @Override
    @CachePut(key = "#id")
    public City updateCity(String id, City city) {
        cityDao.updateById(city);
        return city;
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteById(String id) {
        cityDao.deleteById(id);
    }

    @Override
    @Cacheable(key = "#id")
    public City findById(String id) {
            City city = cityDao.selectById(id);
            if (city == null) {
                return null;
            }
            return city;
    }

    @Override
    @Cacheable
    public List<City> search(City city) {
        List<City> cities = getCities(city);
        return cities;
    }

    @Override
    @Cacheable
    public PageInfo searchByPage(Integer page, Integer size, City city) {
        PageHelper.startPage(page, size);
        List<City> cities = getCities(city);
        PageInfo<City> pageInfo = new PageInfo<>(cities);

        return pageInfo;
    }

    private List<City> getCities(City city) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("id", city.getId());
        queryWrapper.like("name", city.getName());
        queryWrapper.like("ishot", city.getIshot());
        return cityDao.selectList(queryWrapper);
    }

    @Override
    public void ttlDelete(String id) {
        LOGGER.info("发送延时消息...");
        deleteCitySender.send(id, "30000");
    }


}
