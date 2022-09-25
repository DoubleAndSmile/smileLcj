package com.iflytek.classroommanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName profession
 */
@TableName(value ="profession")
@Data
public class Profession implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 专业名称
     */
    private String name;

    /**
     * 专业描述
     */
    private String detail;

    /**
     * 专业编号
     */
    private String proNo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}