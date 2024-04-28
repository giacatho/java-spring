package sg.nus.iss.jpa.extra.workshop.model.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
   @Id
   private int id;
   private String name;
   @Column(name = "matric_no")
   private String matricNo;
   private double cap;

   @ManyToOne
   private Department department;

   @ManyToMany
   @JoinTable(name="student_course", 
      joinColumns = @JoinColumn(name = "student_id"), 
      inverseJoinColumns = @JoinColumn(name="course_id"))
   private List<Course> courses;
   
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

   public double getCap() {
      return cap;
   }

   public void setCap(double cap) {
      this.cap = cap;
   }

   public Department getDepartment() {
      return department;
   }

   public void setDepartment(Department department) {
      this.department = department;
   }

   public List<Course> getCourses() {
      return courses;
   }

   public void setCourses(List<Course> courses) {
      this.courses = courses;
   }

   public String getMatricNo() {
      return matricNo;
   }

   public void setMatricNo(String matricNo) {
      this.matricNo = matricNo;
   }

   @Override
   public String toString() {
      return "Student [id=" + id + ", name=" + name + ", matricNo=" + matricNo + ", CAP=" + cap + "]";
   }
}
