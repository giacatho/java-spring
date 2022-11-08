package sg.edu.nus.iss.springjpa;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.nus.iss.springjpa.model.Course;
import sg.edu.nus.iss.springjpa.model.Lecturer;
import sg.edu.nus.iss.springjpa.repository.CourseRepository;
import sg.edu.nus.iss.springjpa.repository.LecturerRepository;

@SpringBootApplication
public class SpringJpaDemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringJpaDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRun(CourseRepository courseRepo, LecturerRepository lecturerRepo) {
    return args -> {
      Course fopcs = courseRepo.save(new Course("FOPCS", "Foundations of Programming with C#", "Write programs using C# with Visual Studio"));
      Course oopcs = courseRepo.save(new Course("OOPCS", "Object Oriented Programming", "Understand and program on main Object Oriented concepts"));
      Course aspNet = courseRepo.save(new Course("ASP.NET", "ASP.NET MVC Programming", "Understand and develop web applications using ASP.NET MVC"));
      
      System.out.println("Find all courses");
      List<Course> myCourses = courseRepo.findAll();
      myCourses.forEach(myCourse -> System.out.println(myCourse));
      
      System.out.println("Find by code ASP.NET");
      myCourses = courseRepo.findByCode("ASP.NET");
      myCourses.forEach(myCourse -> System.out.println(myCourse));
      
      System.out.println("Find by description containing progr");
      myCourses = courseRepo.findByDescriptionContaining("progr");
      myCourses.forEach(myCourse -> System.out.println(myCourse));
      
      Lecturer liuFan = new Lecturer("Liu Fan");
      Lecturer cherWah = new Lecturer("Cher Wah");
      Lecturer tin = new Lecturer("Tin");
      
      liuFan.setMyCourses(Arrays.asList(fopcs));
      cherWah.setMyCourses(Arrays.asList(oopcs, aspNet));
      tin.setMyCourses(Arrays.asList(oopcs, aspNet));
      
      lecturerRepo.save(liuFan);
      lecturerRepo.save(cherWah);
      lecturerRepo.save(tin);
      
      System.out.println("Find all lecturers");
      List<Lecturer> myLecturers = lecturerRepo.findAll();
      myLecturers.forEach(lecturer -> System.out.println(lecturer));
      
      System.out.println("Find courses by lecture name Cher Wah");
      myCourses = courseRepo.findByLecturerName("Cher Wah");
      myCourses.forEach(myCourse -> System.out.println(myCourse));
    };
  }
}
