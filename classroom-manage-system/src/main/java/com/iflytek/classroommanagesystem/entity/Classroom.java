package com.iflytek.classroommanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName classroom
 */
@TableName(value ="classroom")
@Data
public class Classroom implements Serializable {
    /**
     * 教室ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 教室名称
     */
    private String name;

    /**
     * 教室编号
     */
    private String classNo;

    /**
     * 教室座位数
     */
    private Integer siteCount;

    /**
     * 教室是否启用1-启用0-未启用
     */
    private Boolean isUse;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}