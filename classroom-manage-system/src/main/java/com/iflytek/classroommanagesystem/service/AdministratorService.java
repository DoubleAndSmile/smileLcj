package com.iflytek.classroommanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.classroommanagesystem.entity.Administrator;
import com.iflytek.classroommanagesystem.query.AdministratorQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【administrator】的数据库操作Service
* @createDate 2022-09-24 09:29:34
*/
public interface AdministratorService extends IService<Administrator> {

    int insert(Administrator administrator);

    int update(Administrator administrator);

    int updatePassword(Integer adId, String md5Password);

    int updateFreeze(Integer adId, Boolean isFreeze);

    int deleteById(Integer adId);

    int deleteByIds(@Param("adIds") String[] adIds);

    List<Administrator> getAdministratorList(AdministratorQuery query);

    Administrator getAdministratorByAccount(String account);
}
