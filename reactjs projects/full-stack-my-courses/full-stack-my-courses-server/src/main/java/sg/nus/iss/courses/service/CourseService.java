package sg.nus.iss.courses.service;

import java.util.List;

import sg.nus.iss.courses.model.Course;

public interface CourseService {
  List<Course> findAllCourses();
  
  Course findCourse(int id);
  
  Course createCourse(Course course);
  
  Course updateCourse(Course course);
  
  void removeCourse(int id);
}
