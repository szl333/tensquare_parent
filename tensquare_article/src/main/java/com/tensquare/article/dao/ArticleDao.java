package com.tensquare.article.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.article.pojo.Article;
import org.springframework.stereotype.Repository;


/**
 * @author: ligangan
 * @Date: 2020/9/5
 * @Time: 9:20
 */
@Repository
public interface ArticleDao extends BaseMapper<Article> {
    void updateThumbup(String articleId);
}
