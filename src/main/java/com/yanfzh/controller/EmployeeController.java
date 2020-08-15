package com.yanfzh.controller;

import com.yanfzh.bean.Department;
import com.yanfzh.bean.Employee;
import com.yanfzh.mapper.DepartmentMapper;
import com.yanfzh.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yanfzh.mapper.EmployeeMapper.*;

/**
 * @program: spring-boot-webapp
 * @description: 员工列表页面
 * @author: Yanfzh
 * @create: 2020-08-11 11:31
 **/
@Controller
public class EmployeeController {

//若departmentMapper报错，记得在对应接口里面加@Component注解
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    //所有员工列表
   // @GetMapping("/emps")
    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees=employeeMapper.getAllEmployee();
        //System.out.println(employees);
        model.addAttribute("emps",employees);
        //thymeleaf默认会拼串， classpath:/template/xxxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @RequestMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        List<Department> departments=departmentMapper.allDept();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
   // @RequestMapping("/emp"),用requestmapping不行呢
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("保存的员工信息："+employee);
        List<Department> departments=departmentMapper.allDept();
        Integer num=Integer.valueOf(employee.getDepartment());
        Department department=departments.get(num);
//        System.out.println(departments);
//        System.out.println("将设置的部门名: "+department.getDepartmentName());
        employee.setDepartment(department.getDepartmentName());
        //保存员工
        employeeMapper.insertEmp(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
           return "redirect:/emps";
         }

         //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        //页面要显示所有的部门列表
        List<Department> departments=departmentMapper.allDept();
        model.addAttribute("depts",departments);

        Employee employee= employeeMapper.getEmpByTheId(id);
        //System.out.println("想要修改的员工信息：  "+employee);
        model.addAttribute("emp",employee);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        //System.out.println("修改的员工数据："+employee);
        employeeMapper.UpdateEmp(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        //System.out.println("要删除的员工的ID是： "+id);
        employeeMapper.deleteEmp(id);
        return "redirect:/emps";
    }


}