package sg.nus.iss.jpa.getstarted.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sg.nus.iss.jpa.getstarted.workshop.model.domain.Course;
import sg.nus.iss.jpa.getstarted.workshop.model.repository.CourseRepository;

@Controller
public class CourseController {
  @Autowired
  CourseRepository courseRepository;
  
  @GetMapping("courses")
  public String courseOfTheDay(Model model) {
    List<Course> courses = courseRepository.findAll();
    
    model.addAttribute("courseList", courses);
    
    return "course-list";
  }
}