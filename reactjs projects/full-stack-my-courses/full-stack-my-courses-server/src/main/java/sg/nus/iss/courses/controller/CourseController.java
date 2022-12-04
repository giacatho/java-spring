package sg.nus.iss.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.iss.courses.model.Course;
import sg.nus.iss.courses.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
  @Autowired
  private CourseService courseService;
  
  @GetMapping("/courses")
  public List<Course> getAllCourses() {
    return courseService.findAllCourses();
  }
  
  
  
  
}
