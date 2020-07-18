package dao;

import bean.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author qby
 * @date 2020/7/18 17:43
 */
public class TeacherDaoTest {
    private TeacherDao teacherDao;
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
        teacherDao = sqlSession.getMapper(TeacherDao.class);

        System.out.println(teacherDao.getClass());
    }

    @After
    public void afterTest() {
//        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void getTeacherById() {
        Teacher teacherById = teacherDao.getTeacherById(1);
        System.out.println(teacherById);
    }

    @Test
    public void getTeacherByCondition() {

        Teacher teacher = new Teacher();
//        teacher.setId(2);
        teacher.setName("%tom%");
        List<Teacher> teacherByCondition = teacherDao.getTeacherByCondition(teacher);
        System.out.println(teacherByCondition);
    }

    @Test
    public void getTeacherByInIn() {
        List<Teacher> teacherByInIn = teacherDao.getTeacherByInIn(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(teacherByInIn);
    }

    @Test
    public void getTeacherByConditionChoose() {
        Teacher teacher = new Teacher();
//        teacher.setId(2);
//        teacher.setName("tom");
        List<Teacher> teacherByConditionChoose = teacherDao.getTeacherByConditionChoose(teacher);
        System.out.println(teacherByConditionChoose);
    }

    @Test
    public void updateTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("啦啦啦");

        teacherDao.updateTeacher(teacher);

        Teacher teacherById = teacherDao.getTeacherById(1);
        System.out.println(teacherById);
    }
}