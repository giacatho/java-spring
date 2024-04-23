package sg.nus.iss.getstarted.workshop.model.repository;

import sg.nus.iss.getstarted.workshop.model.domain.Course;

public class FakeCourseRepository {
  public static Course getTodayCourse() {
    return new Course("JSpring", "Web Application Development with Java Spring");
  }
}
