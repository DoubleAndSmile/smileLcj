package com.iflytek.classroommanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName clazz
 */
@TableName(value ="clazz")
@Data
public class Clazz implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 班级描述
     */
    private String detail;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}