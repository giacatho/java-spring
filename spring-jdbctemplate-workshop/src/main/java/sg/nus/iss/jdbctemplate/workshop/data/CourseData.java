package sg.nus.iss.jdbctemplate.workshop.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.iss.jdbctemplate.workshop.model.Course;

// Concept: java varargs

@Repository
public class CourseData {
  private JdbcTemplate jdbcTemplate;
  
  @Autowired
  public void setDataSource(final DataSource dataSource) {
      jdbcTemplate = new JdbcTemplate(dataSource);
  }
  
  public List<Course> getAllCourses() {
    return jdbcTemplate.query(
      "SELECT id, code, name, description FROM Course", 
      new CourseRowMapper()
    );
  }
  
  public Course getCourseById(int id) {
    return jdbcTemplate.queryForObject(
      "SELECT * FROM Course WHERE id = ?",
      new CourseRowMapper(), 
      id
    );
  }
  
  public List<Course> findCourses(String searchTerm) {
    return jdbcTemplate.query(
        "SELECT id, code, name, description FROM course WHERE description LIKE ?", 
        new CourseRowMapper(),
        "%" + searchTerm + "%"
      );
  }
  
  public boolean createCourse(Course inCourse) {
    int affectedRow = jdbcTemplate.update(
      "INSERT INTO Course VALUES (?, ?, ?, ?)", 
      inCourse.getId(), inCourse.getCode(), inCourse.getName(), inCourse.getDescription()
    );
    
    return affectedRow == 1;
  }
  
  
  public boolean updateCourse(int id, Course inCourse) {
    int affectedRow = jdbcTemplate.update("""
            UPDATE Course 
            SET code = ?, 
                name = ?, 
                description = ? 
            WHERE id = ?
          """, inCourse.getCode(), inCourse.getName(), inCourse.getDescription(), id
    );
    
    return affectedRow == 1;
  }
}
