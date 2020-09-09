package com.spit.pojo;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chens
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbSpit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String content;

    private String publishtime;

    private Integer userid;

    private String nickname;

    private Integer visits;

    private String thumbup;

    private Integer share;

    private String comment;

    private String state;

    private Integer parentid;


}
