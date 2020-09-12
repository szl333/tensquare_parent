package com.tensquare.qa.pojo;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 回答
 * </p>
 *
 * @author fxy
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbReply extends Model<TbReply> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 问题ID
     */
    private String problemid;

    /**
     * 回答内容
     */
    private String content;

    /**
     * 创建日期
     */
    private LocalDateTime createtime;

    /**
     * 更新日期
     */
    private LocalDateTime updatetime;

    /**
     * 回答人ID
     */
    private String userid;

    /**
     * 回答人昵称
     */
    private String nickname;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
