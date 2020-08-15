package com.yanfzh.bean;

/**
 * @program: spring-boot-webapp
 * @description:
 * @author: Yanfzh
 * @create: 2020-08-13 10:25
 **/
public class Department {
    private Integer id;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
