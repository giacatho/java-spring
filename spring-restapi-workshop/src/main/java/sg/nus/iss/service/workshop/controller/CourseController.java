package sg.nus.iss.service.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.iss.service.workshop.model.Course;
import sg.nus.iss.service.workshop.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
  @Autowired
  private CourseService courseService;
    
  @GetMapping("/courses")
  public List<Course> listCourses() {
    return courseService.findAllCourses();
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
