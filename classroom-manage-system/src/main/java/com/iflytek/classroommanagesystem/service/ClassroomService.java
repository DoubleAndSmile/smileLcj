package com.iflytek.classroommanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.classroommanagesystem.entity.Classroom;
import com.iflytek.classroommanagesystem.query.ClassRoomQuery;

import java.util.List;

/**
* @author Administrator
* @description 针对表【classroom】的数据库操作Service
* @createDate 2022-09-24 09:29:34
*/
public interface ClassroomService extends IService<Classroom> {

    int insert(Classroom classroom);

    int update(Classroom classroom);

    int deleteById(Integer classRoomId);

    Classroom getClassroomById(Integer classRoomId);

    List<Classroom> getClassRoomList(ClassRoomQuery query);

    int deleteByIds(String[] classroomIds);
}
