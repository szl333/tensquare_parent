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
public class TbUl extends Model<TbUl> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    private String uid;

    /**
     * 标签ID
     */
    private String lid;


    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

}
