package sg.nus.iss.datajdbc.workshop;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.datajdbc.workshop.model.Course;
import sg.nus.iss.datajdbc.workshop.repository.CourseRepository;

// Reference: https://www.baeldung.com/spring-data-jdbc-intro
// and Spring in Action section 3.2

@SpringBootApplication
public class SpringDatajdbcWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajdbcWorkshopApplication.class, args);
	}

	@Bean
  CommandLineRunner commandLineRun(CourseRepository courseRepository) {
    return args -> {
      System.out.println("---- Find all courses");
      Iterable<Course> myCourses = courseRepository.findAll();
      myCourses.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Search courses having 'program' in their description");
      List<Course> coursesWithProgramming = courseRepository.findByDescriptionContaining("program");
      coursesWithProgramming.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Create a new course");
      courseRepository.save(
          new Course(4, "SQL", "Database Programming", "Write SQL query to manipulate data in MySQL database"));

      System.out.println("---- Find all courses");
      Iterable<Course> newCourses = courseRepository.findAll();
      newCourses.forEach(myCourse -> System.out.println(myCourse));
      
      System.out.println("---- Update course with id = 2");
      Course updateCourse = new Course(2, "OOP", "Object Oriented Programming", "Program with Object Oriented foundations");
      courseRepository.updateCourse(updateCourse.getId(), updateCourse.getCode(), 
                          updateCourse.getName(), updateCourse.getDescription());

      System.out.println("---- Find course with id = 2");
      Optional<Course> myCourseOpt = courseRepository.findById(2);
      if (myCourseOpt.isPresent()) {
        System.out.println(myCourseOpt.get());
      }
    };
  }
}
