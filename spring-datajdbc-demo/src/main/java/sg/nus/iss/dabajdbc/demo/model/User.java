package sg.nus.iss.dabajdbc.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class User {
  @Id
  @Column("id")
  private Long id;

  @Column("username")
  private String username;

  private boolean active;

  public User() {}

  public User(String username) {
    this(username, true);
  }

  public User(String username, boolean active) {
    this.username = username;
    this.active = active;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", active=" + active + "]";
  }

}