package com.qw.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Arkay
 * @Date 2020/9/8 10:31
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_label")
public class Label implements Serializable {
    @TableId
    private String id;
    private String labelname;
    private String state;
    private Long count;
    private String recommend;
    private String fans;

}
