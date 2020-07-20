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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author qby
 * @date 2020/7/18 17:43
 */
public class TeacherDaoTest {
    private TeacherDao teacherDao;
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void beforeTest() {
        // 根据全局配置文件创建出一个 SqlSessionFactory
        // sqlSessionFactory 是sqlSession工程 负责创建SqlSession对象
        // SqlSession sql会话 代表和数据库的一次会话
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis/mybatis-config-test.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
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
        Teacher teacherById1 = teacherDao.getTeacherById(1);
        System.out.println(teacherById1);

        Teacher teacherById2 = teacherDao.getTeacherById(1);
        System.out.println(teacherById2);

        System.out.println(teacherById1 == teacherById2);
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

    @Test
    public void test03() {
        Teacher teacherById1 = teacherDao.getTeacherById(1);
        System.out.println(teacherById1);

//        Teacher teacher = new Teacher();
//        teacher.setId(3);
//        teacher.setName("啦啦啦");
//
//        teacherDao.updateTeacher(teacher);

        Teacher teacherById2 = teacherDao.getTeacherById(1);
        System.out.println(teacherById2);

        System.out.println(teacherById1 == teacherById2);
    }

    @Test
    public void test04() {

        // 参数true自动提交
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);


        TeacherDao teacherDao1 = sqlSession1.getMapper(TeacherDao.class);
        Teacher teacherById1 = teacherDao1.getTeacherById(1);
        sqlSession1.close();
        System.out.println(teacherById1);

        TeacherDao teacherDao2 = sqlSession2.getMapper(TeacherDao.class);
        Teacher teacherById2 = teacherDao2.getTeacherById(1);

        System.out.println(teacherById2);

        sqlSession2.close();
        // 参数true自动提交
        SqlSession sqlSession3 = sqlSessionFactory.openSession(true);
        TeacherDao teacherDao3 = sqlSession3.getMapper(TeacherDao.class);
        Teacher teacherById3 = teacherDao3.getTeacherById(1);

        Teacher teacherById = teacherDao3.getTeacherById(2);
        Teacher teacherById4 = teacherDao3.getTeacherById(2);

        System.out.println(teacherById);
        System.out.println(teacherById4);

        sqlSession3.close();




    }

    @Test
    public void insertBatch() {
        List<Teacher> list = new ArrayList<Teacher>();
        for (int i = 0; i < 1000; i++) {
            Teacher teacher = new Teacher();
            teacher.setName(UUID.randomUUID().toString().substring(0, 5));
            teacher.setCourse(UUID.randomUUID().toString().substring(0, 5));
            list.add(teacher);
        }
        teacherDao.insertBatch(list);
    }
}