package com.iflytek.classroommanagesystem.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iflytek.classroommanagesystem.entity.Menu;
import com.iflytek.classroommanagesystem.entity.ResultData;
import com.iflytek.classroommanagesystem.query.MenuQuery;
import com.iflytek.classroommanagesystem.service.MenuService;
import com.iflytek.classroommanagesystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("back/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("list")
    public String list(){
        return "menu/list";
    }

    @ResponseBody
    @GetMapping("listData")
    public ResultData listData(MenuQuery query, @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "5")Integer limit){
        Page<Menu> pageInfo = PageHelper.startPage(page, limit);
        menuService.getMenuList(query);
        return ResultUtil.success(pageInfo.getTotal(),pageInfo.toPageInfo().getList());
    }


    @GetMapping("edit")
    public String editUI(Integer menuId, Model model){
        model.addAttribute("menu",menuService.getMenuById(menuId));
        return "classroom/edit";
    }

    @ResponseBody
    @PostMapping("edit")
    public Map<String, Object> edit(Menu menu){
        if (menu == null || menu.getId() == null){
            return ResultUtil.failure("编辑失败");
        }
        int num = menuService.updateMenu(menu);
        if (num == 1){
            return ResultUtil.success("编辑成功");
        }
        return ResultUtil.failure("编辑失败");
    }


    @ResponseBody
    @PostMapping("/delete")
    public Map<String, Object> delete(Integer menuId){
        System.out.println(menuId);
        if (menuId == null){
            return ResultUtil.failure("删除失败");
        }
        int num = menuService.deleteById(menuId);
        if (num == 1){
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.failure("删除失败");
    }

}
