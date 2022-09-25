package com.iflytek.classroommanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.classroommanagesystem.entity.Administrator;
import com.iflytek.classroommanagesystem.query.AdministratorQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【administrator】的数据库操作Mapper
* @createDate 2022-09-24 09:29:34
* @Entity com.iflytek.classroommanagesystem.entity.Administrator
*/
public interface AdministratorMapper extends BaseMapper<Administrator> {


    int insert(Administrator administrator);

    int update(Administrator administrator);

    int updatePassword(@Param("adId") Integer adId, @Param("md5Password") String md5Password);

    int updateFreeze(@Param("adId") Integer adId, @Param("isFreeze") Boolean isFreeze);

    int deleteById(Integer adId);

    int deleteByIds(@Param("adIds") String[] adIds);

    List<Administrator> getAdministratorList(AdministratorQuery query);

    Administrator getAdministratorByAccount(String account);


}




