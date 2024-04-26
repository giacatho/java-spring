package sg.nus.iss.jpql.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.jpql.demo.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
  @Query("SELECT s FROM Student s")
  public List<Student> findAllStudents();
  
  @Query("SELECT s " + 
         "FROM Student s " +
         "WHERE s.matricNo LIKE '%C'" +
         "       OR s.matricNo LIKE '%E'")
  public List<Student> findStudentsByMatricNo();
  
  @Query("SELECT s " + 
         "FROM Student s " +
         "ORDER BY s.name")
  public List<Student> findAllStudentsWithOrder();
  
  @Query("SELECT s " + 
         "FROM Student s " +
         "ORDER BY s.matricNo")
  public List<Student> findAllStudentsWithOrderMatric();
  
  @Query("SELECT s " + 
         "FROM Student s " +
         "WHERE s.name LIKE 'B%'")
  public List<Student> findStudentsByNameB();
  
  @Query("SELECT s " +
         "FROM Student s " +
         "WHERE s.matricNo = :matricNo")
  public Student findStudentByMatricNo(@Param("matricNo") String matricNo);
  
  @Query("SELECT s " +
         "FROM Student s " +
         "WHERE s.name LIKE '%man%' " +
         "  AND s.department.name = 'DC'")
  public List<Student> findStudentsByDepartmentAndName();
  
  
//  @Query("SELECT s " + 
//         "FROM Student s " +
//         "WHERE s.courses.code = :courseCode ")
//  public List<Student> findStudentsByCourseCodeIncorrect(@Param("courseCode") String courseCode);

  @Query("SELECT s " + 
         "FROM Student s " +
               "JOIN s.courses c " +
         "WHERE c.code = :courseCode ")
  public List<Student> findStudentsByCourseCode(@Param("courseCode") String courseCode);
}
