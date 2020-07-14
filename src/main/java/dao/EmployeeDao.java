package dao;

import bean.Employee;

public interface EmployeeDao {
    //根据员工ID查找
    public Employee getEmpById(Integer id);
}
