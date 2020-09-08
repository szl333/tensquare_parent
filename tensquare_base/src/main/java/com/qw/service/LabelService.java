package com.qw.service;

import com.entity.Result;
import com.github.pagehelper.PageInfo;
import com.qw.pojo.Label;

import java.util.List;

/**
 * @Author Arkay
 * @Date 2020/9/8 10:35
 * @Version 1.0
 */
public interface LabelService {
    List<Label> findAll();

    Label add(Label label);

    List<Label> toplist();

    List<Label> list();

    Label findById(String id);

    Label updateById(String id, Label label);

    void deleteById(String id);

    PageInfo searchByPage(Integer page, Integer size, Label label);

    List<Label> search(Label label);
}
