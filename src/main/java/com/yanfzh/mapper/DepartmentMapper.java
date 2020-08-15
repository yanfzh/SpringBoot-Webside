package com.yanfzh.mapper;
import com.yanfzh.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: spring-boot-webapp
 * @description:
 * @author: Yanfzh
 * @create: 2020-08-13 10:28
 **/
//指定这是一个操作数据库的mapper,一定要有，可以在SpringBootWebApplication全部配置，这边就可不用写
@Mapper
@Component
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Select("select * from department")
    public List<Department> allDept();

    @Select("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Select("insert into department(departmentName) values(#{departmentName})")
    public int  insertDept(Department department);

    @Select("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);


}
