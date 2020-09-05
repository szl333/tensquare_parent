package com.tensquare.article.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: ligangan
 * @Date: 2020/9/5
 * @Time: 9:23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public Page<Article> findByPage(
            Map<String, Object> map,
            Integer page,
            Integer size) {
        // 设置查询条件
        EntityWrapper<Article> wrapper = new EntityWrapper<>();
        map.forEach((k,v)-> wrapper.eq(k!=null,k,v));
        // 设置分页参数
        Page<Article> pageData =new Page<>(page,size);
        // 执行查询
        List<Article> articles = articleDao.selectPage(pageData, wrapper);
        pageData.setRecords(articles);
        // 返回
        return pageData;
    }
}
