package com.tensquare.article.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.dao.ColumnDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ligangan
 * @Date: 2020/9/7
 * @Time: 17:56
 */
@Service
public class ColumnServiceImpl extends ServiceImpl<ArticleDao, Article> implements ColumnService {

    @Autowired
    private ColumnDao columnDao;
}
