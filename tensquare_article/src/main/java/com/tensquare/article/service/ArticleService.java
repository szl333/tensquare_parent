package com.tensquare.article.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.tensquare.article.pojo.Article;

import java.util.Map;

/**
 * @author: ligangan
 * @Date: 2020/9/5
 * @Time: 9:22
 */
public interface ArticleService extends IService<Article> {
    /**
     * 带条件的文章分页查询
     * @param map   查询条件
     * @param page  当前页
     * @param size  每页条数
     * @return
     */
    Page<Article> findByPage(Map<String, Object> map, Integer page, Integer size);
}





















