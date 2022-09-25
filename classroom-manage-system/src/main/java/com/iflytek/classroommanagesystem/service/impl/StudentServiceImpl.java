package com.iflytek.classroommanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.classroommanagesystem.entity.Student;
import com.iflytek.classroommanagesystem.service.StudentService;
import com.iflytek.classroommanagesystem.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【student】的数据库操作Service实现
* @createDate 2022-09-24 09:29:35
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




