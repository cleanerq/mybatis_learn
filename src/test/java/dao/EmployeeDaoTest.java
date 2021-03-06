package dao;

import bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoTest {
    private EmployeeDao employeeDao;
    private SqlSession sqlSession;

    @Before
    public void beforeTest() {
        // 根据全局配置文件创建出一个 SqlSessionFactory
        // sqlSessionFactory 是sqlSession工程 负责创建SqlSession对象
        // SqlSession sql会话 代表和数据库的一次会话
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取和数据库的一次会话
        // 参数true自动提交
        sqlSession = sqlSessionFactory.openSession(true);
        // class com.sun.proxy.$Proxy7 代理对象
        employeeDao = sqlSession.getMapper(EmployeeDao.class);

        System.out.println(employeeDao.getClass());
    }

    @After
    public void afterTest() {
//        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testGetEmpById() {
        try {
            Employee empById = employeeDao.getEmpById(1);
            System.out.println(empById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmpName("admin123");
        employee.setId(1);
        employeeDao.updateEmployee(employee);
    }


    @Test
    public void testInsertEmployee() {
        try {
            Employee employee = new Employee();
            employee.setEmpName("lisi");
            employee.setEmail("lisi@qq.com");
            employee.setGender(1);
            employee.setLoginAccount("dafa");
            int i = employeeDao.insertEmployee(employee);
            System.out.println(i);
            System.out.println("ID：" + employee.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteEmployee() {
        employeeDao.deleteEmployee(2);
    }

    @Test
    public void testInsertEmployeeFull() {
        try {
            Employee employee = new Employee();
            employee.setEmpName("lisi");
            employee.setEmail("lisi@qq.com");
            employee.setGender(1);
            employee.setLoginAccount("dafa");
            int i = employeeDao.insertEmployeeFull(employee);
            System.out.println(i);
            System.out.println("ID：" + employee.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmpByIdAndEmpName() {
        try {
            Employee empById = employeeDao.getEmpByIdAndEmpName(1, "admin");
            System.out.println(empById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmpByIdAndEmpNameMap() {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("id", "1");
            map.put("empName", "admin");
            map.put("tableName", "t_employee");
            Employee empById = employeeDao.getEmpByIdAndEmpNameMap(map);
            System.out.println(empById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmps() {
        try {
            List<Employee> list = employeeDao.getEmps();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmpByIdReturnMap() {
        try {
            // 返回map时 列名作为key 值为value
            Map<String, Object> empById = employeeDao.getEmpByIdReturnMap(1);
            System.out.println(empById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllEmpsReturnMap() {
        try {
            // 返回map时 列名作为key 值为value
            Map<Integer, Employee> empById = employeeDao.getAllEmpsReturnMap();
            System.out.println(empById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}