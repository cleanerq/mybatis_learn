package dao;

import bean.Employee;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class EmployeeDaoTest extends TestCase {
    @Test
    public void testGetEmpById() {
        // 根据全局配置文件创建出一个 SqlSessionFactory
        // sqlSessionFactory 是sqlSession工程 负责创建SqlSession对象
        // SqlSession sql会话 代表和数据库的一次会话
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取和数据库的一次会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee empById = employeeDao.getEmpById(1);
            System.out.println(empById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}