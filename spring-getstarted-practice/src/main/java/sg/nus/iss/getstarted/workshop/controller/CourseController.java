package sg.nus.iss.getstarted.workshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sg.nus.iss.getstarted.workshop.model.domain.Course;
import sg.nus.iss.getstarted.workshop.model.repository.FakeCourseRepository;

@Controller
public class CourseController {
  @GetMapping("courses")
  public String courseOfTheDay(Model model) {
    List<Course> courses = FakeCourseRepository.getCourses();
    
    model.addAttribute("courseList", courses);
    
    return "course-list";
  }
}
