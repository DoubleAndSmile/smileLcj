package com.iflytek.classroommanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.classroommanagesystem.entity.Menu;
import com.iflytek.classroommanagesystem.query.MenuQuery;
import com.iflytek.classroommanagesystem.service.MenuService;
import com.iflytek.classroommanagesystem.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 26826
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2022-09-26 11:11:36
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

    @Autowired
    MenuMapper menuMapper;

    @Override
    public int updateMenu(Menu menu) {
        if (menu == null || menu.getId() == null) {
            return 0;
        }
        return menuMapper.updateMenu(menu);
    }

    @Override
    public int updateMenuUse(Integer menuId, Boolean isUse) {
        if (menuId == null || isUse == null){
            return 0;
        }
        return menuMapper.updateMenuUse(menuId, isUse);
    }

    @Override
    public int deleteById(Integer menuId) {
        if (menuId == null){
            return 0;
        }
        return menuMapper.deleteById(menuId);
    }

    @Override
    public Menu getMenuById(Integer menuId) {
        if (menuId == null){
            return null;
        }
        return menuMapper.getMenuById(menuId);
    }

    @Override
    public Menu getMenuByCode(String code) {
        if (code == null){
            return null;
        }
        return menuMapper.getMenuByCode(code);
    }

    @Override
    public List<Menu> getMenuList(MenuQuery query) {
        return menuMapper.getMenuList(query);
    }
}




