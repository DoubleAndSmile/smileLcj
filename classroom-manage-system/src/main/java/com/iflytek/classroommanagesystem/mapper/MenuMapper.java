package com.iflytek.classroommanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.classroommanagesystem.entity.Menu;
import com.iflytek.classroommanagesystem.query.MenuQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 26826
* @description 针对表【menu】的数据库操作Mapper
* @createDate 2022-09-26 11:11:36
* @Entity com.iflytek.classroommanagesystem.entity.Menu
*/
public interface MenuMapper extends BaseMapper<Menu> {
    int updateMenu(Menu menu);

    int updateMenuUse(@Param("menuId") Integer menuId,@Param("isUse") Boolean isUse);

    int deleteById(Integer menuId);

    Menu getMenuById(Integer menuId);

    Menu getMenuByCode(String code);

    List<Menu> getMenuList(MenuQuery query);

}




