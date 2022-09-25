package com.iflytek.classroommanagesystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iflytek.classroommanagesystem.entity.Administrator;
import com.iflytek.classroommanagesystem.entity.ResultData;
import com.iflytek.classroommanagesystem.query.AdministratorQuery;
import com.iflytek.classroommanagesystem.service.AdministratorService;
import com.iflytek.classroommanagesystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("back/admin")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @GetMapping("list")
    public String list(){
        return "admin/list";
    }

    @ResponseBody
    @GetMapping("listData")
    public ResultData listData(AdministratorQuery query, @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "5")Integer limit){
        Page<Administrator> pageInfo = PageHelper.startPage(page, limit);
        administratorService.getAdministratorList(query);
        return ResultUtil.success(pageInfo.getTotal(),pageInfo.toPageInfo().getList());
    }

    @GetMapping("add")
    public String addUI(){
        return "admin/add";
    }

    @ResponseBody
    @PostMapping("add")
    public Map<String, Object> add(Administrator administrator){
        if (administrator == null){
            return ResultUtil.failure("添加失败");
        }
        QueryWrapper wrapper_name = new QueryWrapper();
        wrapper_name.eq("account",administrator.getAccount());
        Administrator cr = administratorService.getOne(wrapper_name);
        if (cr != null){
            return ResultUtil.failure("添加失败!账号已存在！");
        }
        administrator.setPassword(DigestUtils.md5DigestAsHex(administrator.getPassword().getBytes()));
        int num = administratorService.insert(administrator);
        if (num == 1){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.failure("添加失败");
    }

    @GetMapping("edit")
    public String editUI(Integer administratorId, Model model){
        Administrator administrator = administratorService.getById(administratorId);
        model.addAttribute("administrator",administrator);
        return "admin/edit";
    }

    @ResponseBody
    @PostMapping("edit")
    public Map<String, Object> edit(Administrator administrator){
        System.out.println(administrator);
        if (administrator == null || administrator.getId() == null){
            return ResultUtil.failure("编辑失败");
        }
//        administrator.setPassword(DigestUtils.md5DigestAsHex(administrator.getPassword().getBytes()));
        int num = administratorService.update(administrator);
        if (num == 1){
            return ResultUtil.success("编辑成功");
        }
        return ResultUtil.failure("编辑失败");
    }


    @ResponseBody
    @PostMapping("/delete")
    public Map<String, Object> delete(Integer administratorId){
        System.out.println(administratorId);
        if (administratorId == null){
            return ResultUtil.failure("删除失败");
        }
        int num = administratorService.deleteById(administratorId);
        if (num == 1){
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.failure("删除失败");
    }

    @ResponseBody
    @PostMapping("/batchDelete")
    public Map<String, Object> batchDelete(String adminIds){
        if (adminIds == null){
            return ResultUtil.failure("删除失败");
        }
        int num = administratorService.deleteByIds(adminIds.split(","));
        if (num > 0){
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.failure("删除失败");
    }

    @ResponseBody
    @PostMapping("/resetPwd")
    public Map<String, Object> resetPwd(Integer adminId){
        if (adminId == null){
            return ResultUtil.failure("重置密码失败！");
        }
        String md5Pwd = DigestUtils.md5DigestAsHex("123456".getBytes());
        int num = administratorService.updatePassword(adminId,md5Pwd);
        if (num > 0){
            return ResultUtil.success("重置密码成功!");
        }
        return ResultUtil.failure("重置密码失败！");
    }

    //冻结管理员账号
    @ResponseBody
    @PostMapping("/freezeAdmin")
    public Map<String, Object> freezeAdmin(Integer adminId){
        if (adminId == null){
            return ResultUtil.failure("冻结账号失败！");
        }
        int num = administratorService.updateFreeze(adminId,true);
        if (num > 0){
            return ResultUtil.success("冻结账号成功!");
        }
        return ResultUtil.failure("冻结账号失败！");
    }


    //解冻管理员账号
    @ResponseBody
    @PostMapping("/unfreezeAdmin")
    public Map<String, Object> unfreezeAdmin(Integer adminId){
        if (adminId == null){
            return ResultUtil.failure("解冻账号失败！");
        }
        int num = administratorService.updateFreeze(adminId,false);
        if (num > 0){
            return ResultUtil.success("解冻账号账号成功!");
        }
        return ResultUtil.failure("解冻账号失败！");
    }
}
