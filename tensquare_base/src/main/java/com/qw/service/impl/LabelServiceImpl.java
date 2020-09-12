package com.qw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.PageResult;
import com.entity.Result;
import com.entity.StatusCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qw.dao.LabelDao;
import com.qw.pojo.Label;
import com.qw.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Arkay
 * @Date 2020/9/8 10:36
 * @Version 1.0
 */
@Service
@CacheConfig(cacheNames = "label")
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelDao labelDao;

    @Override
    @Cacheable(key = "#root.method.name")
    public List<Label> findAll() {
        return labelDao.selectList(null);
    }

    @Override
    @Cacheable(key = "#label.id")
    public Label add(Label label) {
        labelDao.insert(label);
        return label;
    }

    @Override
    @Cacheable(key = "#root.method.name")
    public List<Label> toplist() {
        QueryWrapper<Label> labelQueryWrapper = new QueryWrapper<>();
        labelQueryWrapper.eq("recommend", "1");
        return labelDao.selectList(labelQueryWrapper);
    }

    @Override
    @Cacheable(key = "#root.method.name")
    public List<Label> list() {
        QueryWrapper<Label> labelQueryWrapper = new QueryWrapper<>();
        labelQueryWrapper.eq("state", "1");
        return labelDao.selectList(labelQueryWrapper);
    }

    @Override
    @Cacheable(key = "#id")
    public Label findById(String id) {
        return labelDao.selectById(id);
    }

    @Override
    @CachePut(key = "#id")
    public Label updateById(String id, Label label) {
        labelDao.updateById(label);
        return label;
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    @Override
    @Cacheable
    public PageInfo searchByPage(Integer page, Integer size, Label label) {
        PageHelper.startPage(page, size);
        List<Label> labels = getLabels(label);
        PageInfo<Label> labelPageInfo = new PageInfo<>(labels);
        return labelPageInfo;
    }

    @Override
    @Cacheable
    public List<Label> search(Label label) {
        List<Label> labels = getLabels(label);
        return labels;
    }

    private List<Label> getLabels(Label label) {
        QueryWrapper<Label> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("id", label.getId());
        queryWrapper.like("labelname", label.getLabelname());
        queryWrapper.like("state", label.getState());
        queryWrapper.eq("count", label.getCount());
        queryWrapper.like("recommend", label.getRecommend());
        return labelDao.selectList(queryWrapper);
    }
}
