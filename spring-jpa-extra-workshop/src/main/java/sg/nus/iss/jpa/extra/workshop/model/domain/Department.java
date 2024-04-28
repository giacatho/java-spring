package sg.nus.iss.jpa.extra.workshop.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
   @Id
   private int id;
   private String name;
   
   @OneToMany(mappedBy = "department")
   private List<Student> students;

   public Department() {
      students = new ArrayList<>();
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public List<Student> getStudents() {
      return students;
   }

   public void setStudents(List<Student> students) {
      this.students = students;
   }
   
   public String toString() {
      return "Department no: " + getId() + ", name: " + getName();
   }
}
