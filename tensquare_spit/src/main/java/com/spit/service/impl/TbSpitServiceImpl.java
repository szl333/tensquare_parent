package com.spit.service.impl;

import com.spit.pojo.TbSpit;
import com.spit.dao.TbSpitMapper;
import com.spit.service.TbSpitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chens
 * @since 2020-09-07
 */
@Service
public class TbSpitServiceImpl extends ServiceImpl<TbSpitMapper, TbSpit> implements TbSpitService {

    @Autowired
    private TbSpitMapper tbSpitMapper;

    @Override
    public List<TbSpit> findAll() {
        return tbSpitMapper.selectList(null);
    }

    @Override
    public TbSpit findById(Integer id) {
        return tbSpitMapper.selectById(id);
    }

    @Override
    public void delete(Integer id) {
        tbSpitMapper.deleteById(id);
    }

    @Override
    public String thumbup(Integer id) {
        return tbSpitMapper.selectById(id).getThumbup();
    }
}
