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
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Arkay
 * @Date 2020/9/8 10:36
 * @Version 1.0
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelDao labelDao;

    @Override
    public Result findAll() {
        return new Result(true, StatusCode.OK, "success", labelDao.selectList(null));
    }

    @Override
    public Result add(Label label) {
        labelDao.insert(label);
        return new Result(true, StatusCode.OK, "success");
    }

    @Override
    public Result toplist() {
        QueryWrapper<Label> labelQueryWrapper = new QueryWrapper<>();
        labelQueryWrapper.eq("recommend", "1");
        return new Result(true, StatusCode.OK, "success", labelDao.selectList(labelQueryWrapper));
    }

    @Override
    public Result list() {
        QueryWrapper<Label> labelQueryWrapper = new QueryWrapper<>();
        labelQueryWrapper.eq("state", "1");
        return new Result(true, StatusCode.OK, "success", labelDao.selectList(labelQueryWrapper));
    }

    @Override
    public Result findById(String id) {
        return new Result(true, StatusCode.OK, "success", labelDao.selectById(id));
    }

    @Override
    public Result updateById(String id, Label label) {
        labelDao.updateById(label);
        return new Result(true, StatusCode.OK, "success");
    }

    @Override
    public Result deleteById(String id) {
        labelDao.deleteById(id);
        return new Result(true, StatusCode.OK, "success");
    }

    @Override
    public Result searchByPage(Integer page, Integer size, Label label) {
        PageHelper.startPage(page, size);
        List<Label> labels = getLabels(label);
        PageInfo<Label> labelPageInfo = new PageInfo<>(labels);
        PageResult<Label> labelPageResult = new PageResult<>(labelPageInfo.getTotal(), labelPageInfo.getList());
        return new Result(true, StatusCode.OK, "success", labelPageResult);
    }

    @Override
    public Result search(Label label) {
        List<Label> labels = getLabels(label);
        return new Result(true, StatusCode.OK, "success", labels);
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
