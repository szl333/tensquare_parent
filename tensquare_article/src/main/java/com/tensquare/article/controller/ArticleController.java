package com.tensquare.article.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.entity.PageResult;
import com.entity.Result;
import com.entity.StatusCode;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.util.IdWorker;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    /**
     * POST /article/channel/{channelId}/{page}/{size}
     * 根据频道ID获取文章列表
     */
    @PostMapping("/channel/{channelId}/{page}/{size}")
    public Result channelArticle (
            @PathVariable String channelId,
            @PathVariable Integer page,
            @PathVariable Integer size
    ) {
        if (Objects.isNull(page)){
            page = 1;
        }
        if (Objects.isNull(size)){
            size = 1;
        }
        Page<Article> page1 = new Page<>(page,size);
        Page<Article> page2 = articleService.selectPage(page1,
                new EntityWrapper<Article>().eq(channelId != "", "channelid", channelId)
        );
        PageResult<Article> pageResult = new PageResult<>();
        pageResult.setTotal(page2.getTotal());
        pageResult.setRows(page2.getRecords());
        return new Result()
                .setData(pageResult)
                .setCode(StatusCode.OK)
                .setMessage("成功")
                .setFlag(true);
    }
    /**
     *  POST /article/column/{columnId}/{page}/{size}
     *  根据专栏ID获取文章列表
     * */
    @GetMapping("/column/{columnId}/{page}/{size}")
    public Result columnArticle (
            @PathVariable("columnId") String columnId,
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size
    ) {
        Page<Article> page1 = new Page<>(page,size);
        Page<Article> page2 = articleService.selectPage(page1, new EntityWrapper<Article>()
                .eq(columnId != "", "columnid", columnId)
        );
        PageResult<Article> pageResult = new PageResult<>();
        pageResult.setTotal(page2.getTotal());
        pageResult.setRows(page2.getRecords());
        return new Result()
                .setData(pageResult)
                .setCode(StatusCode.OK)
                .setMessage("成功")
                .setFlag(true);
    }
    /**
     * 1 审核通过
     * 0 审核不通过
     * PUT /article/examine/{articleId} 文章审核
     */
    @PutMapping("/examine/{articleId}")
    public Result examineArticle (@PathVariable String articleId) {
        Article article = new Article();
        article.setState("1");
        article.setId(articleId);
        boolean result = articleService.updateById(article);
        return new Result()
                .setMessage("文章审核成功")
                .setCode(StatusCode.OK)
                .setFlag(true);
    }
    /**
     * GET /article/top
     * 头条文章 1 是头条 ,0不是
     * @return
     */
    @GetMapping("/top")
    public Result topArticle () {
        EntityWrapper<Article> entityWrapper = 
                new EntityWrapper<>();
        entityWrapper.eq("istop",1);
        List<Article> articles = articleService.selectList(entityWrapper);
        return new Result()
                .setFlag(true)
                .setMessage("查询成功")
                .setCode(StatusCode.OK)
                .setData(articles);
    }
}

















