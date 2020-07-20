package controller;

import bean.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.TeacherService;

import java.util.List;

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

    @RequestMapping("/getTeaAll")
    public String getTeaAll(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum, Model model) {

        PageHelper.startPage(pageNum, 5);
        List<Teacher> teaAll = teacherService.getTeaAll();
        // 将查询的结果放在pageInfo中 查询结果是第一个参数
        // 第二个参数传入连续要显示的页码
        PageInfo<Teacher> info = new PageInfo<>(teaAll, 6);

        System.out.println(info.getPageNum());
        System.out.println(info.getPages());
        System.out.println(info.getTotal());
        System.out.println(info.getSize());
        System.out.println(info.getPages());
        System.out.println(info.getPrePage());
        System.out.println(info.getNextPage());
        // 连续分页的页数
        System.out.println(info.getNavigatepageNums());

        model.addAttribute("info", info);

        return "success";
    }
}
