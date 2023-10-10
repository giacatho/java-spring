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
      // Test Address repository
      System.out.println("---- Find all courses");
      List<Course> myCourses = CourseData.getAllCourses();
      myCourses.forEach(myCourse -> System.out.println(myCourse));
    };
	}
}
