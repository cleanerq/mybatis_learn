package dao;

import bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    //根据员工ID查找
    public Employee getEmpById(Integer id);

    public int updateEmployee(Employee employee);

    public boolean deleteEmployee(Integer id);

    public int insertEmployee(Employee employee);

    public int insertEmployeeFull(Employee employee);

    public Employee getEmpByIdAndEmpName(@Param("id") Integer id, @Param("empName") String empName);

    public Employee getEmpByIdAndEmpNameMap(Map<String, Object> map);

    public List<Employee> getEmps();
}
