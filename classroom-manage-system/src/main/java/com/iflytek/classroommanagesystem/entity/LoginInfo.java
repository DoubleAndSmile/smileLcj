package com.iflytek.classroommanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName login_info
 */
@TableName(value ="login_info")
@Data
public class LoginInfo implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 登入账号
     */
    private String account;

    /**
     * 登入者姓名
     */
    private String name;

    /**
     * 登入时间
     */
    private Date loginTime;

    /**
     * 登入IP
     */
    private String loginIp;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}