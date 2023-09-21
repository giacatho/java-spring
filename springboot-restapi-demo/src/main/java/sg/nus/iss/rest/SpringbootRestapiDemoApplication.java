package sg.nus.iss.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.rest.model.Course;
import sg.nus.iss.rest.repository.CourseRepository;

@SpringBootApplication
public class SpringbootRestapiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestapiDemoApplication.class, args);
	}

	@Bean
  CommandLineRunner loadData(CourseRepository courseRepository) {
    return (args) -> {  
      // Add a few courses
      Course course1 = new Course();
      course1.setCode("FOPCS");
      course1.setName("Fundamentals of Programming in C#");
      course1.setDescription("FOPCS description");
      courseRepository.save(course1);
      
      Course course2 = new Course();
      course2.setCode("OOPCS");
      course2.setName("Object Oriented Programing");
      course2.setDescription("OOPCS description");
      courseRepository.save(course2);
    };
  }
}
