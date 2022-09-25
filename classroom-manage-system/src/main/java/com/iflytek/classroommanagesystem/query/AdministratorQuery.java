package com.iflytek.classroommanagesystem.query;

import lombok.Data;

@Data
public class AdministratorQuery {

    /**
     * 姓名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String gender;

    /**
     * 是否冻结
     */
    private Boolean isFreeze;
}
