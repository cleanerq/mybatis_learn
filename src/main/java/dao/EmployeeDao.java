package dao;

import bean.Employee;

public interface EmployeeDao {
    //根据员工ID查找
    public Employee getEmpById(Integer id);

    public int updateEmployee(Employee employee);

    public boolean deleteEmployee(Integer id);

    public int insertEmployee(Employee employee);

    public int insertEmployeeFull(Employee employee);
}
