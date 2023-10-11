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
      CourseData.startup();
      
      System.out.println("---- Create some courses");
      CourseData.createCourse(new Course(1, "FOPCS", "Foundations of Programming with C#", "Write programs using C# with Visual Studio"));
      CourseData.createCourse(new Course(2, "OOPCS", "Object Oriented with C#", "Understand and program on main Object Oriented concepts"));
      CourseData.createCourse(new Course(3, "MVC.NET", "ASP.NET MVC Programming", "Understand and develop web applications using ASP.NET MVC"));
      
      System.out.println("---- Find all courses");
      List<Course> myCourses = CourseData.getAllCourses();
      myCourses.forEach(myCourse -> System.out.println(myCourse));
      
      System.out.println("---- Update course with id = 2");
      CourseData.updateCourse(2, new Course("OOP", "Object Oriented Programming", "Program with Object Oriented foundations"));
      
      System.out.println("---- Find course with id = 2");
      Course myCourse = CourseData.getCourse(2);
      System.out.println(myCourse);
      
    };
	}
}
