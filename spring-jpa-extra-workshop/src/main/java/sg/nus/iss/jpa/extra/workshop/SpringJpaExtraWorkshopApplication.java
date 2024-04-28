package sg.nus.iss.jpa.extra.workshop;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.jpa.extra.workshop.model.domain.Course;
import sg.nus.iss.jpa.extra.workshop.model.domain.Student;
import sg.nus.iss.jpa.extra.workshop.repository.CourseRepository;
import sg.nus.iss.jpa.extra.workshop.repository.DepartmentRepository;
import sg.nus.iss.jpa.extra.workshop.repository.StudentRepository;

@SpringBootApplication
public class SpringJpaExtraWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaExtraWorkshopApplication.class, args);
	}

	@Bean
  CommandLineRunner testJPAExtraWorkshop(StudentRepository studentRepo, DepartmentRepository departmentRepo) {
    return args -> {
      List<Student> students;
      List resultList;
      
      System.out.println("--- findAllStudentsWithOrderCAP() ---");
      students = studentRepo.findAllStudentsWithOrderCAP();
      students.forEach(student -> System.out.println(student));
        
      System.out.println("--- findStudentsByNameN() ---");
      students = studentRepo.findStudentsByNameN();
      students.forEach(student -> System.out.println(student));

      System.out.println("--- findStudentsByMinCAP() ---");
      students = studentRepo.findStudentsByMinCAP();
      students.forEach(student -> System.out.println(student));
      
      System.out.println("--- findMarvelStudentsByCAP() ---");
      students = studentRepo.findMarvelStudentsByMinCAP();
      students.forEach(student -> System.out.println(student));
      
      System.out.println("--- findStudentAndCourses() ---");
      resultList = studentRepo.findStudentAndCourses();
      for (Iterator i = resultList.iterator(); i.hasNext();) {
        Object[] values = (Object[]) i.next();

        for (int j = 0; j < values.length; j++)
          System.out.print(values[j] + " ");
        System.out.println();
      }
      
      System.out.println("--- findDepartmentsWithAverageCAP() ---");
      resultList = departmentRepo.findDepartmentsWithAverageCAP();
      for (Iterator i = resultList.iterator(); i.hasNext();) {
        Object[] values = (Object[]) i.next();

        for (int j = 0; j < values.length; j++)
          System.out.print(values[j] + " ");
        System.out.println();
      }
    };
  }
	
  @Bean
  CommandLineRunner testSampleQueriesInLecture(StudentRepository studentRepo, CourseRepository courseRepo,
      DepartmentRepository departmentRepo) {
    return args -> {
      List<Student> students;
      List<Course> courses;
      List resultList;
      
      System.out.println("--- findAllStudents() ---");
      students = studentRepo.findAllStudents();
      students.forEach(student -> System.out.println(student));

      System.out.println("--- findAllStudentsWithOrder() ---");
      students = studentRepo.findAllStudentsWithOrder();
      students.forEach(student -> System.out.println(student));

      System.out.println("--- findStudentsByMatricNo() ---");
      students = studentRepo.findStudentsByMatricNo();
      students.forEach(student -> System.out.println(student));

      System.out.println("--- findStudentByMatricNo() ---");
      Student myStudent = studentRepo.findStudentByMatricNo("A00002B");
      System.out.println(myStudent);

      System.out.println("--- findStudentsByDepartmentAndName() ---");
      students = studentRepo.findStudentsByDepartmentAndName();
      students.forEach(student -> System.out.println(student));

      System.out.println("--- findStudentsByCourseCode() ---");
      students = studentRepo.findStudentsByCourseCode("SQL");
      students.forEach(student -> System.out.println(student.getName() + ", " + student.getDepartment().getName()));

      System.out.println("--- findByStudentMatricNo() ---");
      courses = courseRepo.findByStudentMatricNo("A00003C");
      courses.forEach(course -> System.out.println(course));

      System.out.println("--- findByStudentMatricNo2() ---");
      courses = courseRepo.findByStudentMatricNo2("A00003C");
      courses.forEach(course -> System.out.println(course));

      System.out.println("--- aggregateQuery() ---");
      List results = departmentRepo.aggregateQuery();
      for (Iterator i = results.iterator(); i.hasNext();) {
        Object[] values = (Object[]) i.next();

        for (int j = 0; j < values.length; j++)
          System.out.print(values[j] + " ");
        System.out.println();
      }

    };
  }

}
