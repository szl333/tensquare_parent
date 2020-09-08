package com.qw.controller;

import com.entity.Result;
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
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 查询所有标签
     * @return
     */
    @GetMapping
    public Result findAll() {
        return labelService.findAll();
    }

    /**
     * 添加标签
     * @param label
     * @return
     */
    @PostMapping
    public Result addLabel(@RequestBody Label label) {
        return labelService.add(label);
    }

    /**
     * 查询所有推荐标签
     * @return
     */
    @GetMapping("/toplist")
    public Result toplist() {
        return labelService.toplist();
    }

    /**
     * 查询所有有效标签
     * @return
     */
    @GetMapping("/list")
    public Result list() {
        return labelService.list();
    }

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    @GetMapping("/{labelId}")
    public Result findById(@PathVariable("labelId") String id) {
        return labelService.findById(id);
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
        return labelService.updateById(id, label);
    }

    /**
     * 根据Id删除标签
     * @param id
     * @return
     */
    @DeleteMapping("/{labelId}")
    public Result deleteById(@PathVariable("labelId") String id) {
        return labelService.deleteById(id);
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
        return labelService.searchByPage(page, size, label);
    }

    /**
     * 根据条件查询
     * @param label
     * @return
     */
    @PostMapping("/search")
    public Result search(@RequestBody Label label) {
        return labelService.search(label);
    }
}
