package com.tensquare.article.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: ligangan
 * @Date: 2020/9/7
 * @Time: 17:56
 */
@TableName("tb_column")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Column {
    @TableId(type = IdType.INPUT)
    private String id;
    private String name;
    private String summary;
    private String userid;
    private Date createtime;
    private Date checktime;
    private String state;
}
