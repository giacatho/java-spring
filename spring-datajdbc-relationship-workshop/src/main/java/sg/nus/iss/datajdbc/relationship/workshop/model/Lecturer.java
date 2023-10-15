package sg.nus.iss.datajdbc.relationship.workshop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "lecturer")
public class Lecturer {
  @Id
  private int id;
  private String username;
  @Column(value = "firstname")
  private String firstName;
  @Column(value = "lastname")
  private String lastName;
  
  public Lecturer() { 
  }
  
  public Lecturer(int id, String username, String firstName, String lastName) {
    this(username, firstName, lastName);
    this.id = id;
  }
  
  public Lecturer(String username, String firstName, String lastName) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  @Override
  public String toString() {
    return "Lecturer [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
        + "]";
  }
  
  
}
