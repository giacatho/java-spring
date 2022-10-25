package sg.edu.nus.iss.validator.demo.model;

import javax.validation.constraints.Size;

public class User {
  @Size(min=3, max=20, message = "username must be 3-20 characters")
  private String username;
  
  @Size(min=6, message = "password must be at least 6 characters")
  private String password;
  
  public User() {}
  
  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
