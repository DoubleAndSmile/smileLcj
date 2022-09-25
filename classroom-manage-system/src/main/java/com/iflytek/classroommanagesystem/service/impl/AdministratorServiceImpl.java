package com.iflytek.classroommanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.classroommanagesystem.entity.Administrator;
import com.iflytek.classroommanagesystem.query.AdministratorQuery;
import com.iflytek.classroommanagesystem.service.AdministratorService;
import com.iflytek.classroommanagesystem.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
* @author Administrator
* @description 针对表【administrator】的数据库操作Service实现
* @createDate 2022-09-24 09:29:34
*/
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator>
    implements AdministratorService{

    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public int insert(Administrator administrator) {
        if (administrator == null){
            return 0;
        }
        return administratorMapper.insert(administrator);
    }

    @Override
    public int update(Administrator administrator) {
        if (administrator == null || administrator.getId() == null){
            return 0;
        }
        Administrator oldAdmin = administratorMapper.selectById(administrator.getId());
        if (oldAdmin == null){
            return 0;
        }
        return administratorMapper.update(administrator);
    }

    @Override
    public int updatePassword(Integer adId, String md5Password) {
        if (adId == null || StringUtils.isEmpty(md5Password)){
            return 0;
        }
        return administratorMapper.updatePassword(adId,md5Password);
    }

    @Override
    public int updateFreeze(Integer adId, Boolean isFreeze) {
        if (adId == null || isFreeze == null){
            return 0;
        }
        return administratorMapper.updateFreeze(adId,isFreeze);
    }

    @Override
    public int deleteById(Integer adId) {
        if (adId == null){
            return 0;
        }
        Administrator administrator = administratorMapper.selectById(adId);
        if (administrator == null){
            return 0;
        }
        return administratorMapper.deleteById(adId);
    }

    @Override
    public int deleteByIds(String[] adIds) {
        if (adIds == null || adIds.length == 0){
            return 0;
        }
        return administratorMapper.deleteByIds(adIds);
    }

    @Override
    public List<Administrator> getAdministratorList(AdministratorQuery query) {
        return administratorMapper.getAdministratorList(query);
    }

    @Override
    public Administrator getAdministratorByAccount(String account) {
        if (StringUtils.isEmpty(account)){
            return null;
        }
        return administratorMapper.getAdministratorByAccount(account);
    }
}




