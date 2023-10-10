package sg.nus.iss.jdbc.workshop.data;

import java.sql.Connection;
import java.sql.DriverManager;
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
//  public static List<Course> GetAllCourses()
//  {
//      List<Course> courses = new List<Course>();
//
//      using (SqlConnection conn = new SqlConnection(Data.CONNECTION_STRING))
//      {
//          conn.Open();
//          string sql = @"SELECT ID, Code, Name
//                      FROM Course";
//          SqlCommand cmd = new SqlCommand(sql, conn);
//          SqlDataReader reader = cmd.ExecuteReader();
//
//          while (reader.Read())
//          {
//              Course course = new Course()
//              {
//                  ID = (int)reader["ID"],
//                  Code = (string)reader["Code"],
//                  Name = (string)reader["Name"]
//              };
//              courses.Add(course);
//          }
//      }
//
//      return courses;
//  }
//
//  public static Course GetCourseDetailsByCourseId(int courseId)
//  {
//      Course course = null;
//
//      using (SqlConnection conn = new SqlConnection(Data.CONNECTION_STRING))
//      {
//          conn.Open();
//
//          string sql = @"SELECT Course.Id, Course.Code, Course.Name as CourseName, Course.Description
//                      FROM Course
//                      WHERE Course.Id = " + courseId;
//
//          SqlCommand cmd = new SqlCommand(sql, conn);
//
//          SqlDataReader reader = cmd.ExecuteReader();
//          if (reader.Read())
//          {
//              course = new Course()
//              {
//                  ID = (int)reader["Id"],
//                  Code = (string)reader["Code"],
//                  Name = (string)reader["CourseName"],
//                  Description = (string)reader["Description"],
//              };
//          };
//      }
//
//      return course;
//  }

}
