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
 * @TableName send_email_log
 */
@TableName(value ="send_email_log")
@Data
public class SendEmailLog implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 发件人ID
     */
    private Integer senderId;

    /**
     * 收件人ID
     */
    private Integer recederId;

    /**
     * 发送时间
     */
    private Date senderTime;

    /**
     * 发送状态：0-失败1-成功
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}