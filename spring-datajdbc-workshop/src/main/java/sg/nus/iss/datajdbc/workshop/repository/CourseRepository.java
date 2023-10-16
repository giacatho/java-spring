package sg.nus.iss.datajdbc.workshop.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.datajdbc.workshop.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{
  public List<Course> findByDescriptionContaining(String searchTerm);
  
  @Modifying
  @Query("UPDATE Course SET code=:newCode, name=:newName, description=:newDescription WHERE id=:id")
  boolean updateCourse(@Param("id") Integer id, 
        @Param("newCode") String newCode, 
        @Param("newName") String newName, 
        @Param("newDescription") String newDescription);
  
  @Query("""
      SELECT *
      FROM Course, LecturerCourse
      WHERE Course.Id = LecturerCourse.CourseId AND
      LecturerCourse.LecturerId = :lecturerId
    """)
  public List<Course> findByLecturerId(@Param("lecturerId") int lectureId);
  
}
