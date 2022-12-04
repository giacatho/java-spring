package sg.nus.iss.courses.service;

import java.util.List;
import java.util.Optional;

import sg.nus.iss.courses.model.Course;

public interface CourseService {
  List<Course> findAllCourses();
  
  Optional<Course> findCourse(int id);
  
  Course createCourse(Course course);
  
  Course updateCourse(Course course);
  
  void deleteCourse(int id);
}
