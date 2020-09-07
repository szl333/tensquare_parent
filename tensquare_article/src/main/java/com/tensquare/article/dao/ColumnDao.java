package com.tensquare.article.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.article.pojo.Article;
import org.springframework.stereotype.Repository;

/**
 * @author ligangan
 */
@Repository
public interface ColumnDao extends BaseMapper<Article> {
}
