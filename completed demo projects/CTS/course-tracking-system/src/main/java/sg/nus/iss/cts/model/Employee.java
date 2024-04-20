package sg.nus.iss.cts.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
  private static final long serialVersionUID = 6529685098267757670L;
  @Id
  @Column(name = "employeeid")
  private String employeeId;
  
  private String name;
  
  @Column(name = "managerid")
  private String managerId;

  public Employee() { }
  
  public Employee(String employeeId, String name) {
    this(employeeId, name, null);
  }

  public Employee(String employeeId, String name, String managerId) {
    this.employeeId = employeeId;
    this.name = name;
    this.managerId = managerId;
  }
  
  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }

}
