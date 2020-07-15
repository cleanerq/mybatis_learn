package annotation;

import bean.Employee;
import dao.EmployeeDao;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author qby
 * @date 2020/7/15 23:41
 */
public class EmployeeDaoAnnotationTest {
    private EmployeeDaoAnnotation employeeDao;
    private SqlSession sqlSession;

    @Before
    public void beforeTest() {
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
        // 参数true自动提交
        sqlSession = sqlSessionFactory.openSession(true);
        // class com.sun.proxy.$Proxy7 代理对象
        employeeDao = sqlSession.getMapper(EmployeeDaoAnnotation.class);

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
}