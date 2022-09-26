package com.iflytek.classroommanagesystem.query;

import lombok.Data;

@Data
public class MenuQuery {
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
}
