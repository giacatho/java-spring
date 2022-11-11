package sg.edu.nus.iss.springjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.nus.iss.springjpa.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
  public List<Course> findByCode(String code);
  public List<Course> findByDescriptionContaining(String str);
  
  @Query("SELECT c "
      + "FROM Lecturer l "
      + "JOIN l.myCourses c "
      + "WHERE l.name LIKE %:lecturerName%")
  public List<Course> findByLecturerName(@Param("lecturerName") String name);
}
