package com.qw.service;

import com.entity.Result;
import com.qw.pojo.Label;

/**
 * @Author Arkay
 * @Date 2020/9/8 10:35
 * @Version 1.0
 */
public interface LabelService {
    Result findAll();

    Result add(Label label);

    Result toplist();

    Result list();

    Result findById(String id);

    Result updateById(String id, Label label);

    Result deleteById(String id);

    Result searchByPage(Integer page, Integer size, Label label);

    Result search(Label label);
}
