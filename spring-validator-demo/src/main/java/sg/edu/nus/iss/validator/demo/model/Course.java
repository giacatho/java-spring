package sg.edu.nus.iss.validator.demo.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class Course {
  
  @NotBlank(message = "Course code is required")
  private String code;
  
  @NotBlank(message = "Course name is required")
  private String name;
  
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date startDate;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date endDate;
  
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
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  
  
}