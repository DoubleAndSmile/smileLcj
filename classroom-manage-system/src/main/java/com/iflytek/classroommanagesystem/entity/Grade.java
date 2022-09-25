package com.iflytek.classroommanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName grade
 */
@TableName(value ="grade")
@Data
public class Grade implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 年级名称
     */
    private String name;

    /**
     * 年级描述
     */
    private String detail;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}