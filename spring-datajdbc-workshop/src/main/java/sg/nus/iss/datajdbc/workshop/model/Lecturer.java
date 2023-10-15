package sg.nus.iss.datajdbc.workshop.model;

public class Lecturer {
  private int id;
  private String username;
  private String firstName;
  private String lastName;
  
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
