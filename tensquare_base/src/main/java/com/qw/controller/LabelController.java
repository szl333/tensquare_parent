package com.qw.controller;

import com.entity.PageResult;
import com.entity.Result;
import com.entity.StatusCode;
import com.github.pagehelper.PageInfo;
import com.qw.pojo.Label;
import com.qw.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Arkay
 * @Date 2020/9/8 10:33
 * @Version 1.0
 */
@RestController
@RequestMapping("label")
@CrossOrigin
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 查询所有标签
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "success", labelService.findAll());
    }

    /**
     * 添加标签
     * @param label
     * @return
     */
    @PostMapping
    public Result addLabel(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "success");
    }

    /**
     * 查询所有推荐标签
     * @return
     */
    @GetMapping("/toplist")
    public Result toplist() {
        return new Result(true, StatusCode.OK, "success", labelService.toplist());
    }

    /**
     * 查询所有有效标签
     * @return
     */
    @GetMapping("/list")
    public Result list() {
        return new Result(true, StatusCode.OK, "success", labelService.list());
    }

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    @GetMapping("/{labelId}")
    public Result findById(@PathVariable("labelId") String id) {
        return new Result(true, StatusCode.OK, "success", labelService.findById(id));
    }

    /**
     * 根据Id修改标签
     * @param id
     * @param label
     * @return
     */
    @PutMapping("/{labelId}")
    public Result updateById(@PathVariable("labelId") String id,
                             @RequestBody Label label) {
        labelService.updateById(id, label);
        return new Result(true, StatusCode.OK, "success");
    }

    /**
     * 根据Id删除标签
     * @param id
     * @return
     */
    @DeleteMapping("/{labelId}")
    public Result deleteById(@PathVariable("labelId") String id) {
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "success");
    }

    /**
     * 根据条件分页查询
     * @param page
     * @param size
     * @param label
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public Result searchByPage(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size,
                               @RequestBody Label label) {
        PageInfo pageInfo = labelService.searchByPage(page, size, label);
        PageResult<Label> labelPageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
        return new Result(true, StatusCode.OK, "success", labelPageResult);
    }

    /**
     * 根据条件查询
     * @param label
     * @return
     */
    @PostMapping("/search")
    public Result search(@RequestBody Label label) {
        return new Result(true, StatusCode.OK, "success", labelService.search(label));
    }
}
