package com.spit.controller;


import com.spit.pojo.TbSpit;
import com.spit.service.TbSpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chens
 * @since 2020-09-07
 */
@RestController
@RequestMapping("/spit")
public class TbSpitController {
    @Autowired
    private TbSpitService tbSpitService;

    @GetMapping("findAll")
    public List<TbSpit> findAll() {
        return tbSpitService.findAll();
    }


    @GetMapping("findById/{spitId}")
    public TbSpit findById(@PathVariable Integer spitId) {

        return tbSpitService.findById(spitId);
    }

    @GetMapping("delete/{spitId}")
    public void delete(Integer spitId) {
        tbSpitService.delete(spitId);
    }

    @GetMapping("thumbup/{spitId}")
    public String thunbup(@PathVariable Integer spitId) {
        return tbSpitService.thumbup(spitId);
    }
}
