package sg.nus.iss.jdbctemplate.workshop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.jdbctemplate.workshop.data.CourseData;
import sg.nus.iss.jdbctemplate.workshop.model.Course;

@SpringBootApplication
public class SpringJdbctemplateWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbctemplateWorkshopApplication.class, args);
	}

	@Bean
  CommandLineRunner commandLineRun(CourseData courseData) {
    return args -> {
      System.out.println("---- Find all courses");
      List<Course> myCourses = courseData.getAllCourses();
      myCourses.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Search courses having 'program' in their description");
      List<Course> coursesWithProgramming = courseData.findCourses("program");
      coursesWithProgramming.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Create a new course");
      courseData.createCourse(
          new Course(4, "SQL", "Database Programming", "Write SQL query to manipulate data in MySQL database"));

      System.out.println("---- Find all courses");
      List<Course> newCourses = courseData.getAllCourses();
      newCourses.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Update course with id = 2");
      courseData.updateCourse(2,
          new Course("OOP", "Object Oriented Programming", "Program with Object Oriented foundations"));

      System.out.println("---- Find course with id = 2");
      Course myCourse = courseData.getCourseById(2);
      System.out.println(myCourse);
    };
	}
}
