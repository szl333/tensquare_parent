package com.tensquare.qa.controller;


import com.entity.Result;
import com.entity.StatusCode;
import com.tensquare.qa.pojo.TbProblem;
import com.tensquare.qa.service.TbProblemService;
import com.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 问题 前端控制器
 * </p>
 *
 * @author fxy
 * @since 2020-09-08
 */
@RestController
public class TbProblemController {

    @Autowired
    private TbProblemService tbProblemService;

    @Autowired
    private IdWorker idWorker;

    @RequestMapping(value = "/problem")
    public Result addProblem(@RequestBody TbProblem problem) {
        String id = idWorker.nextId() + "";
        problem.setId(id);
        tbProblemService.insert(problem);
        return new Result(true, StatusCode.OK, "增加问题成功");
    }
}
