package com.iflytek.classroommanagesystem.query;

import lombok.Data;

@Data
public class ClassRoomQuery {
    /**
     * 教室名称
     */
    private String name;

    /**
     * 教室编号
     */
    private String classNo;

    /**
     * 教室是否启用1-启用0-未启用
     */
    private Integer isUse;
}
