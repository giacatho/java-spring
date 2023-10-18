package sg.nus.iss.jdbc.workshop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.jdbc.workshop.data.CourseData;
import sg.nus.iss.jdbc.workshop.model.Course;

@SpringBootApplication
public class SpringJdbcWorkshopApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringJdbcWorkshopApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRun() {
    return args -> {
      // CourseData.startup();

      System.out.println("---- Find all courses");
      List<Course> myCourses = CourseData.getAllCourses();
      myCourses.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Search courses having 'program' in their description");
      List<Course> coursesWithProgramming = CourseData.findCoures("program");
      coursesWithProgramming.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Create a new course");
      CourseData.createCourse(
          new Course(4, "SQL", "Database Programming", "Write SQL query to manipulate data in MySQL database"));

      System.out.println("---- Find all courses");
      List<Course> newCourses = CourseData.getAllCourses();
      newCourses.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Update course with id = 2");
      CourseData.updateCourse(2,
          new Course("OOP", "Object Oriented Programming", "Program with Object Oriented foundations"));

      System.out.println("---- Find course with id = 2");
      Course myCourse = CourseData.getCourse2(2);
      System.out.println(myCourse);

    };
  }
}
