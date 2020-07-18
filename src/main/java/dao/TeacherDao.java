package dao;

import bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qby
 * @date 2020/7/18 17:39
 */
public interface TeacherDao {

    public Teacher getTeacherById(Integer id);

    public List<Teacher> getTeacherByCondition(Teacher bean);

    public List<Teacher> getTeacherByInIn(@Param("ids") List<Integer> idList);
}
