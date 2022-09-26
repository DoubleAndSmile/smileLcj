package com.iflytek.classroommanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName menu
 */
@TableName(value ="menu")
@Data
public class Menu implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 上级菜单编码
     */
    private String parentCode;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 是否启用：0-未启用，1-启用
     */
    private Integer isUse;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}