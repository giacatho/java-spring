package sg.nus.iss.service.workshop.service;

import java.util.List;
import java.util.Optional;

import sg.nus.iss.service.workshop.model.Course;


public interface CourseService {
  List<Course> findAllCourses();
  
  Optional<Course> findCourseById(int id);
  
  Course createCourse(Course course);
  
  Course updateCourse(Course course);
}
