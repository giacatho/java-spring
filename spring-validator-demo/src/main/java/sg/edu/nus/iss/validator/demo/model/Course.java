package sg.edu.nus.iss.validator.demo.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;

public class Course {
  @NotBlank(message = "Course code is required")
  private String code;
  
  @NotBlank(message = "Course name is required")
  private String name;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate endDate;
  
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
  public LocalDate getStartDate() {
    return startDate;
  }
  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
  
  public LocalDate getEndDate() {
    return endDate;
  }
  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }
  
  
}