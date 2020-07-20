package service;

import bean.Teacher;
import dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qby
 * @date 2020/7/19 15:39
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public Teacher getTeacherById(Integer id) {
        return teacherDao.getTeacherById(id);
    }

}
