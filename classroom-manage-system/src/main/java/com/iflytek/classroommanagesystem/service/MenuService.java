package com.iflytek.classroommanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.classroommanagesystem.entity.Menu;
import com.iflytek.classroommanagesystem.query.MenuQuery;

import java.util.List;

/**
* @author 26826
* @description 针对表【menu】的数据库操作Service
* @createDate 2022-09-26 11:11:36
*/
public interface MenuService extends IService<Menu> {
    int updateMenu(Menu menu);

    int updateMenuUse(Integer menuId,Boolean isUse);

    int deleteById(Integer menuId);

    Menu getMenuById(Integer menuId);

    Menu getMenuByCode(String code);

    List<Menu> getMenuList(MenuQuery query);
}
