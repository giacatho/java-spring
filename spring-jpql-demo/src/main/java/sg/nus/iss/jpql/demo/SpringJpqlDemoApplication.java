package sg.nus.iss.jpql.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.jpql.demo.domain.Student;
import sg.nus.iss.jpql.demo.model.repository.CourseRepository;
import sg.nus.iss.jpql.demo.model.repository.DepartmentRepository;
import sg.nus.iss.jpql.demo.model.repository.StudentRepository;

@SpringBootApplication
public class SpringJpqlDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringJpqlDemoApplication.class, args);
  }

  @Bean
  CommandLineRunner testSampleQueriesInLecture(StudentRepository studentRepo, CourseRepository courseRepo,
      DepartmentRepository departmentRepo) {
    return args -> {
//      List<Student> students = studentRepo.findAllStudents();
//      students.forEach(student -> System.out.println(student));
//
//      List<Student> students = studentRepo.findAllStudentsWithOrder();
//      students.forEach(student -> System.out.println(student));
//
//      List<Student> students = studentRepo.findStudentsByMatricNo();
//      students.forEach(student -> System.out.println(student));
//
//Student student = studentRepo.findStudentByMatricNo("A00002B");
//System.out.println(student);
//
//      List<Student> students = studentRepo.findStudentsByDepartmentAndName();
//      students.forEach(student -> System.out.println(student));
//
//List<Student> students = studentRepo.findStudentsByCourseCode("SQL");
//students.forEach(student -> System.out.println(student.getName() + ", " + student.getDepartment().getName()));
//
//List<Course> courses = courseRepo.findByStudentMatricNo("A00003C");
//courses.forEach(course -> System.out.println(course));
//
//      List<Course> courses = courseRepo.findByStudentMatricNo2("A00003C");
//      courses.forEach(course -> System.out.println(course));
//
//      List results = departmentRepo.aggregateQuery();
////      List results = departmentRepo.aggregateQueryWithHaving();
//      for (Iterator i = results.iterator(); i.hasNext();) {
//        Object[] values = (Object[]) i.next();
//
//        for (int j = 0; j < values.length; j++)
//          System.out.print(values[j] + " ");
//        System.out.println();
//      }

    };
  }
  
  @Bean
  CommandLineRunner testJPAExtraWorkshop(StudentRepository studentRepo, CourseRepository courseRepo,
      DepartmentRepository departmentRepo) {
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

}
