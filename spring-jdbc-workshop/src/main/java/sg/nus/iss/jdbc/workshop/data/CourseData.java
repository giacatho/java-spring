package sg.nus.iss.jdbc.workshop.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sg.nus.iss.jdbc.workshop.model.Course;

public class CourseData {
  static String dbURL = "jdbc:mysql://localhost:3306/JdbcWorkshop";
  static String username = "root";
  static String password = "adminadmin";
  
  public static void startup() {
    try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
      Statement statement = conn.createStatement();
      statement.addBatch("DROP TABLE IF EXISTS Course");
      statement.addBatch("""
          CREATE TABLE Course(
            id int NOT NULL,
            code varchar(50) NOT NULL,
            name varchar(250) NOT NULL,
            description varchar(300) NOT NULL,
            PRIMARY KEY (id)
          )
          """);
      
      statement.executeBatch();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
  public static List<Course> getAllCourses() {
    List<Course> courses = new ArrayList<Course>();
    
    try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
      String sql = """  
          SELECT id, code, name, description 
          FROM course
          """;
      
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
       
      while (result.next()){
        int id = result.getInt("id");
        String code = result.getString("code");
        String name = result.getString("name");
        String description = result.getString("description");
        
        courses.add(new Course(id, code, name, description));
      }       
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    
    return courses;
  }
  
  public static List<Course> findCoures(String term) {
    List<Course> courses = new ArrayList<Course>();
    
    try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
      // Read more: https://stackoverflow.com/a/8248052/1343667
      String sql = "SELECT id, code, name, description FROM course WHERE description LIKE ?";
      
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, "%" + term + "%");       
      
      ResultSet result = statement.executeQuery();
      while (result.next()){
        int id = result.getInt("id");
        String code = result.getString("code");
        String name = result.getString("name");
        String description = result.getString("description");
        
        courses.add(new Course(id, code, name, description));
      }       
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    
    return courses;
  }

  public static Course getCourse(int courseId) {
    Course course = null;
    
    try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
      String sql = String.format("""  
          SELECT id, code as courseCode, name, description 
          FROM course
          WHERE id = %d 
          """, courseId);
      
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
       
      if (result.next()) {
        int id = result.getInt("id");
        String code = result.getString("courseCode");
        String name = result.getString("name");
        String description = result.getString("description");
        
        course = new Course(id, code, name, description);
      }       
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    
    return course;
  }
  
  public static boolean createCourse(Course inCourse) {
    try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
      String sql = String.format("""  
          INSERT INTO Course (id, code, name, description) 
          VALUES (%d, '%s', '%s', '%s')
          """, inCourse.getId(), inCourse.getCode(), inCourse.getName(), inCourse.getDescription());
      
      Statement statement = conn.createStatement();
      int rowsInserted = statement.executeUpdate(sql);
      
      if (rowsInserted == 1) {
        return true;
      }
       
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    
    return false;
  }
  
  public static boolean updateCourse(int id, Course inCourse) {
    try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {  
      String sql = String.format("""
            UPDATE Course 
            SET code = '%s', 
                name = '%s', 
                description = '%s' 
            WHERE id = %d
          """, inCourse.getCode(), inCourse.getName(), inCourse.getDescription(), id);
       
      Statement statement = conn.createStatement();
      int rowsUpdated = statement.executeUpdate(sql);
    
      if (rowsUpdated == 1) {
          return true;
      }
       
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    
    return false;
  }
}
