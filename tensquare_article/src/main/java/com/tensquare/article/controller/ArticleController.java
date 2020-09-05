package com.tensquare.article.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.entity.PageResult;
import com.entity.Result;
import com.entity.StatusCode;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.util.IdWorker;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: ligangan
 * @Date: 2020/9/5
 * @Time: 9:27
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private IdWorker idWorker;

    /**
     * GET /article
     * 获取文章的全部列表
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        List<Article> articles = articleService.selectList(null);
        return new Result()
                .setCode(StatusCode.OK)
                .setData(articles)
                .setFlag(true)
                .setMessage("查询成功");
    }

    /**
     * 根据文章id查询具体文章信息
     * GET /article/{articleId}
     *
     * @return
     */
    @GetMapping("/{articleId}")
    public Result findAll(@PathVariable String articleId) {
        Article article = articleService.selectById(articleId);
        return new Result()
                .setCode(StatusCode.OK)
                .setMessage("查询成功")
                .setFlag(true)
                .setData(article);
    }

    /**
     * POST /article
     * 文章新增
     */
    @PostMapping
    public Result save(@RequestBody Article article) {
        // 雪花id生成器
        String id = idWorker.nextId() + "";
        article.setId(id);
        // 初始化数据
        // 浏览量，点赞量，评论量
        article.setVisits(0);
        article.setThumbup(0);
        article.setComment(0);
        articleService.insert(article);
        return new Result()
                .setCode(StatusCode.OK)
                .setFlag(true)
                .setMessage("新增成功");
    }

    /**
     * PUT /article/{articleId}
     * 文章修改
     */
    @PutMapping("/{articleId}")
    public Result updateById(
            @PathVariable String articleId,
            @RequestBody Article article
    ) {
        article.setId(articleId);
        articleService.updateById(article);

        return new Result()
                .setCode(StatusCode.OK)
                .setFlag(true)
                .setMessage("修改成功");
    }
    /**
     * 删除 文章
     * DELETE /article/{articleId}
     */
    @DeleteMapping("/{articleId}")
    public Result deleteById(@PathVariable String articleId) {
        // 成功就成功，错误就报异常
        articleService.deleteById(articleId);
        return new Result()
                .setMessage("删除成功")
                .setFlag(true)
                .setCode(StatusCode.OK);
    }
    /**
     * 文章分页
     * POST /article/search/{page}/{size}
     */
    @PostMapping("/search/{page}/{size}")
    public Result findByPage (
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size,
            @RequestBody Map<String,Object> map
            ) {

        Page<Article> pageData = articleService.findByPage(
                map,
                page,
                size
        );

        PageResult<Article> pageResult = new PageResult<Article>(
                pageData.getTotal(),
                pageData.getRecords()
        );
        return new Result()
                .setCode(StatusCode.OK)
                .setFlag(true)
                .setMessage("查询成功")
                .setData(pageResult);
    }
    /**
     * 文章分页
     * POST /article/search/{page}/{size}
     */
    @PostMapping("/search")
    public Result findByCondition (
            @RequestBody Map<String,Object> map
    ) {
       List<Article> data = articleService.findByCondition(map);
        return new Result()
                .setCode(StatusCode.OK)
                .setFlag(true)
                .setMessage("查询成功")
                .setData(data);
    }

    /**
     * PUT /
     *{
     *   "code": 0,
     *   "flag": true,
     *   "message": "string"
     * }
     * 点赞 /article/thumbup/{articleId}
     * @return
     */
    @PutMapping("/thumbup/{articleId}")
    public Result updateThumbup(@PathVariable String articleId){
        articleService.updateThumbup(articleId);
        return new Result()
                .setCode(StatusCode.OK)
                .setFlag(true)
                .setMessage("更新点赞成功");
    }
}

















