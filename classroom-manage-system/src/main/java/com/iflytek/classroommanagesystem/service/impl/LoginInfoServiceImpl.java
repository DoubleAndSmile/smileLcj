package com.iflytek.classroommanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.classroommanagesystem.entity.LoginInfo;
import com.iflytek.classroommanagesystem.service.LoginInfoService;
import com.iflytek.classroommanagesystem.mapper.LoginInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【login_info】的数据库操作Service实现
* @createDate 2022-09-24 09:29:35
*/
@Service
public class LoginInfoServiceImpl extends ServiceImpl<LoginInfoMapper, LoginInfo>
    implements LoginInfoService{

}




