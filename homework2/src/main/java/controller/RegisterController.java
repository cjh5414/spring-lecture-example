package controller;

import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CourseService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("course", new Course());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createCourse(@Valid Course course, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors)
                System.err.println(error.getDefaultMessage());

            return "register";
        }

        if (!courseService.insert(course))
            System.err.println("Error: Fail to insert Course data");

        return "redirect: registered_courses";
    }

    @RequestMapping(value = "/registered_courses")
    public String showRegisteredCourses(Model model) {
        model.addAttribute("courses", courseService.getRegisteredCourses());

        return "registered_courses";

    }

    @RequestMapping("/registration")
    public String showRegistration(@RequestParam(required=false) Integer year, @RequestParam(required=false) Integer semester, Model model) {
        List<Course> courses;
        if (year != null && semester != null)
            courses = courseService.getCourses(year, semester);
        else
            courses = courseService.getCourses();

        model.addAttribute("courses", courses);
        return "registration";
    }

}
