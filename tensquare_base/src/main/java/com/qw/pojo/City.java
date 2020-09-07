package com.qw.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Arkay
 * @Date 2020/9/7 15:51
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_city")
public class City {
    @TableId
    private String id;

    @TableField("name")
    private String name;

    @TableField("ishot")
    private String ishot;
}
