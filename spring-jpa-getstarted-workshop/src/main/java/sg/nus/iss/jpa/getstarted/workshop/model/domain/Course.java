package sg.nus.iss.jpa.getstarted.workshop.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
  @Id
  private int id;
  private String code;
  private String name;
  
  public Course() {}
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
}
