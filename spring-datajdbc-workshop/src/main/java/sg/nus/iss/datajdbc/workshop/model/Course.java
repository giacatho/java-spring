package sg.nus.iss.datajdbc.workshop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "course")
public class Course {
  @Id
  private int id;
  private String code;
  private String name;
  private String description;
  
  public Course() {}
  
  public Course(String code, String name, String description) {
    this.code = code;
    this.name = name;
    this.description = description;
  }
  
  public Course(int id, String code, String name, String description) {
    this(code, name, description);
    this.id = id;
  }

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + "]";
  }
  
  
}
