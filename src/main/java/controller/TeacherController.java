package controller;

import bean.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.TeacherService;

/**
 * @author qby
 * @date 2020/7/19 16:33
 */
@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getTea")
    public String getTeacher(Integer integer, Model model) {
        Teacher teacherById = teacherService.getTeacherById(integer);
        model.addAttribute("teacher", teacherById);
        return "success";
    }
}
