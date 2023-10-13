package sg.nus.iss.jdbctemplate.workshop.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sg.nus.iss.jdbctemplate.workshop.model.Course;

public class CourseRowMapper implements RowMapper<Course> {

  @Override
  public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    Course retCourse = new Course();
    
    retCourse.setId(resultSet.getInt("id"));
    retCourse.setCode(resultSet.getString("code"));
    retCourse.setName(resultSet.getString("name"));
    retCourse.setDescription(resultSet.getString("description"));
    
    return retCourse;
  }

}
