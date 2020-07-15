package annotation;

import bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeDaoAnnotation {
    //根据员工ID查找
    // 可以使用注解解析SQL
    @Select("select * from t_employee where id = #{id}")
    public Employee getEmpById(Integer id);

    public int updateEmployee(Employee employee);

    public boolean deleteEmployee(Integer id);

    public int insertEmployee(Employee employee);
}
