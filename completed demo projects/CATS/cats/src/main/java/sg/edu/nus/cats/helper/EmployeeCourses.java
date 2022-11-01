package sg.edu.nus.cats.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import sg.edu.nus.cats.model.Course;
import sg.edu.nus.cats.model.Employee;

public class EmployeeCourses {

	private Employee employee = null;
  private List<Course> courses = null;
  
  public EmployeeCourses() {}
  
  public Employee getEmployee() {
    return employee;
  }
  
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
  
  public List<Course> getCourses() {
    return courses;
  }
  
  public void setCourses(ArrayList<Course> courses) {
    this.courses = courses;
  }

  @Override
  public int hashCode() {
    return Objects.hash(courses, employee);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EmployeeCourses other = (EmployeeCourses) obj;
    return Objects.equals(courses, other.courses) && Objects.equals(employee, other.employee);
  }

  @Override
  public String toString() {
    return "EmployeeCourses [employee=" + employee + ", courses=" + courses + "]";
  }
  
  
}
