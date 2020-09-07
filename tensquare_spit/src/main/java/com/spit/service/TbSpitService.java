package com.spit.service;

import com.spit.pojo.TbSpit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chens
 * @since 2020-09-07
 */
public interface TbSpitService extends IService<TbSpit> {
    List<TbSpit> findAll();
}
