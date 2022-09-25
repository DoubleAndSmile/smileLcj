package com.iflytek.classroommanagesystem.utils;

import com.iflytek.classroommanagesystem.entity.ResultData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultUtil {

    private static final String CODE = "code";
    private static final String MSG = "msg";


    private ResultUtil(){}

    public static <T> ResultData success(Long count, List<T> data){
        return new ResultData<T>(ResultData.SUCCESS_NUM,"请求成功",count,data);
    }

    public static <T> ResultData failure(){
        return new ResultData<T>(ResultData.FAILURE_NUM,"请求失败",0L,null);
    }

    public static Map<String, Object> success(String msg){
        Map<String, Object> map = new HashMap<>();
        map.put(MSG,msg);
        map.put(CODE,ResultData.SUCCESS_NUM);
        return map;
    }

    public static Map<String, Object> failure(String msg){
        Map<String, Object> map = new HashMap<>();
        map.put(MSG,msg);
        map.put(CODE,ResultData.FAILURE_NUM);
        return map;
    }

}
