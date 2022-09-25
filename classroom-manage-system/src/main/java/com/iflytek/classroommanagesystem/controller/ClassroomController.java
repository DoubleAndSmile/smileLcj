package com.iflytek.classroommanagesystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iflytek.classroommanagesystem.entity.Classroom;
import com.iflytek.classroommanagesystem.entity.ResultData;
import com.iflytek.classroommanagesystem.query.ClassRoomQuery;
import com.iflytek.classroommanagesystem.service.ClassroomService;
import com.iflytek.classroommanagesystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("back/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("list")
    public String list(){
        return "classroom/list";
    }

    @ResponseBody
    @GetMapping("listData")
    public ResultData listData(ClassRoomQuery query, @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "5")Integer limit){
        Page<Classroom> pageInfo = PageHelper.startPage(page, limit);
        classroomService.getClassRoomList(query);
        return ResultUtil.success(pageInfo.getTotal(),pageInfo.toPageInfo().getList());
    }

    @GetMapping("add")
    public String addUI(){
        return "classroom/add";
    }

    @ResponseBody
    @PostMapping("add")
    public Map<String, Object> add(Classroom classroom){
        Map<String, Object> map = new HashMap<>();
        if (classroom == null){
            return ResultUtil.failure("添加失败");
        }
        QueryWrapper wrapper_name = new QueryWrapper();
        wrapper_name.eq("name",classroom.getName());
        Classroom cr = classroomService.getOne(wrapper_name);
        if (cr != null){
            return ResultUtil.failure("添加失败!教室名称已存在！");
        }

        QueryWrapper wrapper_classNo = new QueryWrapper();
        wrapper_classNo.eq("class_no",classroom.getClassNo());
        cr = classroomService.getOne(wrapper_classNo);
        if (cr != null){
            return ResultUtil.failure("添加失败!教室编号已存在！");
        }
        int num = classroomService.insert(classroom);
        if (num == 1){
            return ResultUtil.success("添加成功");
        }
        return ResultUtil.failure("添加失败");
    }

    @GetMapping("edit")
    public String editUI(Integer classroomId, Model model){
        model.addAttribute("classRoom",classroomService.getClassroomById(classroomId));
        return "classroom/edit";
    }

    @ResponseBody
    @PostMapping("edit")
    public Map<String, Object> edit(Classroom classroom){

        System.out.println(classroom);
        if (classroom == null || classroom.getId() == null){
            return ResultUtil.failure("编辑失败");
        }
        //判断修改的教室名称或编号是否冲突
        Classroom oldClassRoom = classroomService.getClassroomById(classroom.getId());
        if (oldClassRoom == null){
            return ResultUtil.failure("编辑失败");
        }
        if (oldClassRoom == null){
            return ResultUtil.failure("编辑失败");
        }
        if (!oldClassRoom.getName().equals(classroom.getName())){
            QueryWrapper wrapper_name = new QueryWrapper();
            wrapper_name.eq("name",classroom.getName());
            Classroom cr = classroomService.getOne(wrapper_name);
            if (cr != null){
                return ResultUtil.failure("添加失败!教室名称已存在！");
            }
        }
        if (!oldClassRoom.getClassNo().equals(classroom.getClassNo())){
            QueryWrapper wrapper_name = new QueryWrapper();
            wrapper_name.eq("class_no",classroom.getClassNo());
            Classroom cr = classroomService.getOne(wrapper_name);
            if (cr != null){
                return ResultUtil.failure("添加失败!教室编号已存在！");
            }
        }
        int num = classroomService.update(classroom);
        if (num == 1){
            return ResultUtil.success("编辑成功");
        }
        return ResultUtil.failure("编辑失败");
    }


    @ResponseBody
    @PostMapping("/delete")
    public Map<String, Object> delete(Integer classroomId){
        System.out.println(classroomId);
        if (classroomId == null){
            return ResultUtil.failure("删除失败");
        }
        int num = classroomService.deleteById(classroomId);
        if (num == 1){
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.failure("删除失败");
    }

    @ResponseBody
    @PostMapping("/batchDelete")
    public Map<String, Object> batchDelete(String[] classroomIds){
        if (classroomIds == null){
            return ResultUtil.failure("删除失败");
        }
        int num = classroomService.deleteByIds(classroomIds);
        if (num > 0){
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.failure("删除失败");
    }


}
