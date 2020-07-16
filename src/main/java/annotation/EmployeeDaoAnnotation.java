package annotation;

import bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeDaoAnnotation {
    //根据员工ID查找
    // 可以使用注解解析SQL
    @Select("select * from t_employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("        UPDATE t_employee t\n" +
            "        SET t.empname = #{empName},\n" +
            "         gender = #{gender},\n" +
            "         email = #{email}\n" +
            "        WHERE\n" +
            "            t.id = #{id}")
    public int updateEmployee(Employee employee);

    @Delete("delete from t_employee where id = #{id}")
    public boolean deleteEmployee(Integer id);

    @Insert("insert into t_employee(empname, gender, email)\n" +
            "        values(#{empName}, #{gender},#{email})")
    public int insertEmployee(Employee employee);
}
