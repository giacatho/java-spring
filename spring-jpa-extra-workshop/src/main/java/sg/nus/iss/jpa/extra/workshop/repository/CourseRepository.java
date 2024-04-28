package sg.nus.iss.jpa.extra.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.jpa.extra.workshop.model.domain.Course;


public interface CourseRepository extends JpaRepository<Course, Integer> {
@Query("SELECT c " + 
       "FROM Course c " +
             "JOIN c.students s " +
       "WHERE s.matricNo = :matricNo ")
public List<Course> findByStudentMatricNo(@Param("matricNo") String matricNo);
  
  @Query("SELECT c " + 
         "FROM Student s " +
               "JOIN s.courses c " +
         "WHERE s.matricNo = :matricNo ")
  public List<Course> findByStudentMatricNo2(@Param("matricNo") String matricNo);
}
