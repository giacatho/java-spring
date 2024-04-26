package sg.nus.iss.jpql.demo.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
   @Id
   private int id;
   @Column(name = "c_code")
   private String code;
   private String description;
   
   @ManyToMany (mappedBy = "courses")
   private List<Student> students;
   
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getCode() {
      return code;
   }
   public void setCode(String code) {
      this.code = code;
   }
   public String getDescription() {
      return description;
   }
   public void setDescription(String description) {
      this.description = description;
   }
   public List<Student> getStudents() {
      return students;
   }
   public void setStudents(List<Student> students) {
      this.students = students;
   }
   @Override
   public String toString() {
      return "Course [id=" + id + ", code=" + code + ", description=" + description + "]";
   }
}
