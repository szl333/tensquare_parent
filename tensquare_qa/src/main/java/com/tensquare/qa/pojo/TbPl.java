package com.tensquare.qa.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author fxy
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbPl extends Model<TbPl> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     * 设置自定义id
     */
    @TableId(type = IdType.INPUT)
    private String problemid;

    /**
     * 标签ID
     */
    private String labelid;


    @Override
    protected Serializable pkVal() {
        return this.problemid;
    }

}
