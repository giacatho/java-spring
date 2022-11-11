package sg.edu.nus.iss.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sg.edu.nus.iss.springjpa.model.Course;
import sg.edu.nus.iss.springjpa.repository.CourseRepository;

public class SomeClient {
  @Autowired
  private CourseRepository courseRepository;
  
  void doSomething() {
    List<Course> courses = courseRepository.findAll();
    
    courses.forEach(System.out::println);
  }
}
