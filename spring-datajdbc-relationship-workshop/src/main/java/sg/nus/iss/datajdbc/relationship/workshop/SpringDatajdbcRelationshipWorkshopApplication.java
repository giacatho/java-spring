package sg.nus.iss.datajdbc.relationship.workshop;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.datajdbc.relationship.workshop.model.Course;
import sg.nus.iss.datajdbc.relationship.workshop.model.Lecturer;
import sg.nus.iss.datajdbc.relationship.workshop.repository.CourseRepository;
import sg.nus.iss.datajdbc.relationship.workshop.repository.LecturerRepository;

@SpringBootApplication
public class SpringDatajdbcRelationshipWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajdbcRelationshipWorkshopApplication.class, args);
	}

	@Bean
  CommandLineRunner commandLineRun(CourseRepository courseRepository, LecturerRepository lecturerRepository) {
    return args -> {
      System.out.println("---- Find all courses");
      Iterable<Course> myCourses = courseRepository.findAll();
      myCourses.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Search courses having 'program' in their description");
      List<Course> coursesWithProgramming = courseRepository.findByDescriptionContaining("program");
      coursesWithProgramming.forEach(myCourse -> System.out.println(myCourse));

      System.out.println("---- Find all lecturers");
      Iterable<Lecturer> myLecturers = lecturerRepository.findAll();
      myLecturers.forEach(myLecturer -> System.out.println(myLecturer));
      
      System.out.println("---- Find lecturer and his modules with for lecturer id = 2");
      Optional<Lecturer> optLecturer = lecturerRepository.findById(2);
      if (optLecturer.isPresent()) {
        System.out.println(optLecturer.get());
        List<Course> teachingCourses = courseRepository.findByLecturerId(2);
        teachingCourses.forEach(teachingCourse -> System.out.println(teachingCourse));
      }
      
    };
  }
}
