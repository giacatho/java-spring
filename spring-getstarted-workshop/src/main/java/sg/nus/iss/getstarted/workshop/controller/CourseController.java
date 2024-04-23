package sg.nus.iss.getstarted.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sg.nus.iss.getstarted.workshop.model.domain.Course;
import sg.nus.iss.getstarted.workshop.model.repository.FakeCourseRepository;

@Controller
public class CourseController {
  @GetMapping("course-today")
  public String courseOfTheDay(Model model) {
    Course todayCourse = FakeCourseRepository.getTodayCourse(); 
    
    model.addAttribute("course", todayCourse);
    
    return "today-course";
  }
}
