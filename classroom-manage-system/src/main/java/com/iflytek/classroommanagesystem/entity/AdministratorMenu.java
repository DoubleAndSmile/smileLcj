package com.iflytek.classroommanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName administrator_meun
 */
@TableName(value ="administrator_menu")
@Data
public class AdministratorMenu implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 管理员ID
     */
    private Integer administratorId;

    /**
     * 菜单编码
     */
    private String meunCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}