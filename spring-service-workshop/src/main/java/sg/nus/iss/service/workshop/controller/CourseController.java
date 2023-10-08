package sg.nus.iss.service.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.iss.service.workshop.model.Course;
import sg.nus.iss.service.workshop.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController {
  @Autowired
  private CourseService courseService;
    
  @GetMapping("/list")
  public String listCourses(Model model) {
    model.addAttribute("courses", courseService.findAllCourses());
    
    return "course-list";
  }
  
  @GetMapping("/create")
  public String createCourseForm(Model model) {
      Course course = new Course();
      model.addAttribute("course", course);
      
      return "course-create";
  }
  
  @PostMapping("/create")
  public String createCourse(@ModelAttribute("course") Course inCourse) {
    courseService.createCourse(inCourse);
    
    return "redirect:/course/list";
  }
  
}
