package com.tensquare.article.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: ligangan
 * @Date: 2020/9/5
 * @Time: 9:11
 */
@TableName("tb_article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    @TableId(type = IdType.INPUT)
    private String id;
    private String columnid;
    private String userid;
    private String title;
    private String content;
    private Date createtime;
    private Date updatetime;
    private String ispublic;
    private String istop;
    private Integer visits;
    private Integer comment;
    private String state;
    private String channelid;
    private String url;
    private String type;
    private Integer thumbup;
}
