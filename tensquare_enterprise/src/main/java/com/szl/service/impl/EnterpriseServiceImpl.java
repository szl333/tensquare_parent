package com.szl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szl.dao.EnterpriseDao;
import com.szl.entity.Enterprise;
import com.szl.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    private EnterpriseDao enterpriseDao;

    @Override
    public Integer addEnterprise(Enterprise enterprise) {
        return enterpriseDao.insert(enterprise);
    }

    @Override
    public List<Enterprise> findAll() {
        return enterpriseDao.selectList(null);
    }

    @Override
    public Enterprise findById(Integer id) {
//        QueryWrapper<Enterprise> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id",id);
        return enterpriseDao.selectById(id);
    }

    @Override
    public Integer updateById(Integer id, Enterprise enterprise) {
        return enterpriseDao.updateById(enterprise);
    }

    @Override
    public Integer deleteById(Integer id) {
        return enterpriseDao.deleteById(id);
    }

    @Override
    public List<Enterprise> search(Enterprise enterprise) {
        QueryWrapper<Enterprise> queryWrapper = getEnterpriseQueryWrapper(enterprise);
        return enterpriseDao.selectList(queryWrapper);
    }

    @Override
    public PageInfo searchPage(Integer page, Integer size, Enterprise enterprise) {
        PageHelper.startPage(page,size);
        QueryWrapper<Enterprise> queryWrapper = getEnterpriseQueryWrapper(enterprise);
        List<Enterprise> enterprises = enterpriseDao.selectList(queryWrapper);
        PageInfo<Enterprise> pageInfo = new PageInfo<>(enterprises);
        return pageInfo;
    }

    @Override
    public List<Enterprise> searchHotList() {
        QueryWrapper<Enterprise> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("ishot");
        return enterpriseDao.selectList(queryWrapper);
    }

    private QueryWrapper<Enterprise> getEnterpriseQueryWrapper(Enterprise enterprise) {
        QueryWrapper<Enterprise> queryWrapper = new QueryWrapper<>();
        String id=enterprise.getId();
        if (id == null){
            id = "";
        }
        //其它if语句省略
        queryWrapper.like("id", enterprise.getId());
        queryWrapper.like("name", enterprise.getName());
        queryWrapper.like("summary", enterprise.getSummary());
        queryWrapper.like("address", enterprise.getAddress());
        queryWrapper.like("labels", enterprise.getLabels());
        queryWrapper.like("coordinate", enterprise.getCoordinate());
        queryWrapper.like("ishot", enterprise.getIshot());
        queryWrapper.like("logo", enterprise.getLogo());
        queryWrapper.like("jobcount", enterprise.getJobcount());
        queryWrapper.like("url", enterprise.getUrl());
        return queryWrapper;
    }
}
