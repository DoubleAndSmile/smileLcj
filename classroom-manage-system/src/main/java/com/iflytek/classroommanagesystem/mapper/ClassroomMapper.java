package com.iflytek.classroommanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.classroommanagesystem.entity.Classroom;
import com.iflytek.classroommanagesystem.query.ClassRoomQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【classroom】的数据库操作Mapper
* @createDate 2022-09-24 09:29:34
* @Entity com.iflytek.classroommanagesystem.entity.Classroom
*/
public interface ClassroomMapper extends BaseMapper<Classroom> {

    int insert(Classroom classroom);

    int update(Classroom classroom);

    int deleteById(Integer classRoomId);

    Classroom getClassroomById(Integer classRoomId);

    List<Classroom> getClassRoomList(ClassRoomQuery query);

    int deleteByIds(@Param("classroomIds") String[] classroomIds);
}




