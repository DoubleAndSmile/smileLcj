package com.iflytek.classroommanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.classroommanagesystem.entity.Classroom;
import com.iflytek.classroommanagesystem.mapper.ClassroomMapper;
import com.iflytek.classroommanagesystem.query.ClassRoomQuery;
import com.iflytek.classroommanagesystem.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author Administrator
* @description 针对表【classroom】的数据库操作Service实现
* @createDate 2022-09-24 09:29:34
*/
@Service
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom>
    implements ClassroomService{

    @Autowired
    ClassroomMapper classroomMapper;

    @Override
    public int insert(Classroom classroom) {
        if (classroom == null){
            return 0;
        }
        return classroomMapper.insert(classroom);
    }

    @Override
    public int update(Classroom classroom) {
        if (classroom == null || classroom.getId() == null){
            return 0;
        }
        return classroomMapper.update(classroom);
    }

    @Override
    public int deleteById(Integer classRoomId) {
        if (classRoomId == null){
            return 0;
        }
        //判断ID对应的教室信息是否存在
        Classroom classroom = classroomMapper.getClassroomById(classRoomId);
        if(classroom == null){
            return 0;
        }
        return classroomMapper.deleteById(classRoomId);
    }

    @Override
    public Classroom getClassroomById(Integer classRoomId) {
        if (classRoomId == null){
            return null;
        }
        return classroomMapper.getClassroomById(classRoomId);
    }

    @Override
    public List<Classroom> getClassRoomList(ClassRoomQuery query) {
        return classroomMapper.getClassRoomList(query);
    }

    @Override
    public int deleteByIds(String[] classroomIds) {
        if (StringUtils.isEmpty(classroomIds)){
            return 0;
        }
        return classroomMapper.deleteByIds(classroomIds);
    }
}




