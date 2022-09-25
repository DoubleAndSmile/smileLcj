package com.iflytek.classroommanagesystem.entity;

import lombok.Data;

import java.util.List;

@Data
public class ResultData<T> {

    //成功的编码值
    public static final Integer SUCCESS_NUM = 0;
    //失败的编码值
    public static final Integer FAILURE_NUM = -1;
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;

    public ResultData(Integer code, String msg, Long count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}