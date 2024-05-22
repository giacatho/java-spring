package sg.nus.iss.getstarted.workshop.model.repository;

import java.util.ArrayList;
import java.util.List;

import sg.nus.iss.getstarted.workshop.model.domain.Course;

public class FakeCourseRepository {
  public static List<Course> getCourses() {
    List<Course> courses = new ArrayList<>();
    
    courses.add(new Course("FOP", "Fundamentals of Programming"));
    courses.add(new Course("OOP", "Object Oriented Programming"));
    courses.add(new Course("SQL", "Database Programming with SQL"));
    
    return courses;
  }
}
