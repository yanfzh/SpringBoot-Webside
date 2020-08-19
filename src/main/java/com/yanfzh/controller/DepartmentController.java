package com.yanfzh.controller;
import com.yanfzh.bean.Department;
import com.yanfzh.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-boot-webapp
 * @description: 部门crud操作
 * @author: Yanfzh
 * @create: 2020-08-18 16:06
 **/
@Controller
public class DepartmentController {
    @Autowired
    DepartmentMapper departmentMapper;
    //所有部门列表
    @GetMapping("/depts")
    public String list(Model model){
        List<Department> departments=departmentMapper.allDept();
        //System.out.println(departments);
        model.addAttribute("depts",departments);
        return "dep/deptsList";
    }
    //部门添加
    @PostMapping("/dept")
    public String insertDept(Department department){
        //System.out.println("保存的部门："+department);
        //保存
        departmentMapper.insertDept(department);
        return "redirect:/depts";
    }
    //来到修改页面，查出当前部门，在页面回显
    @GetMapping("/dept/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Department department= departmentMapper.getDeptById(id);
        //System.out.println("想要修改的部门：  "+department);
        model.addAttribute("dept",department);
        return "dep/update";
    }
    //部门修改；需要提交部门id；
    @PutMapping("/dept")
    public String updateDepartment(Department department){
        System.out.println("修改的数据："+department);
        departmentMapper.updateDept(department);
        return "redirect:/depts";
    }
    //部门删除
    @DeleteMapping("/dept/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        //System.out.println("要删除的部门ID是： "+id);
        departmentMapper.deleteDept(id);
        return "redirect:/depts";
    }

}
