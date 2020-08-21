package com.yanfzh.mapper;
import com.yanfzh.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
//一定要注意返回类型是employee 还是department，因为报错时查到怀疑人生
//@Mapper或者@MapperScan将接口扫描装配到容器中
@Component
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public Employee getEmpByTheId(Integer id);

    @Select("select * from employee")
    public List<Employee> getAllEmployee();

    @Select("select * from employee where lastName like CONCAT('%',#{lastName},'%')")
    public List<Employee> searchEmps(String lastName);

    @Insert("insert into employee(lastName,email,gender,Department,salary,birth) values (#{lastName},#{email},#{gender},#{department},#{salary},#{birth})")
    public Integer insertEmp(Employee employee);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},Department=#{department},salary=#{salary},birth=#{birth} where id=#{id}")
    public Integer UpdateEmp(Employee employee);

    @Select("delete from employee where id=#{id}")
    public Integer deleteEmp(Integer id);
}
