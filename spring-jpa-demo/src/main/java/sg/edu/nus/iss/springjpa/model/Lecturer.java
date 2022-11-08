package sg.edu.nus.iss.springjpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lecturers")
public class Lecturer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  
  @ManyToMany
  @JoinTable(name="teachings", 
  joinColumns = @JoinColumn(name="lecturer_id"), 
  inverseJoinColumns = @JoinColumn(name="course_id"))
  private List<Course> myCourses;
  
  public Lecturer() {}
  public Lecturer(String name) {
    this.name = name;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public List<Course> getMyCourses() {
    return myCourses;
  }
  public void setMyCourses(List<Course> myCourses) {
    this.myCourses = myCourses;
  }
  
  @Override
  public String toString() {
    return "Lecturer [id=" + id + ", name=" + name + "]";
  }
  
  
}
