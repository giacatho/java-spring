package sg.edu.nus.iss.validator.demo.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Pet {
  @NotBlank(message = "Name is required")
  @Size(min = 2, max = 25, message = "Name must 2-25 characters long")
  private String name;
  
  @NotBlank(message = "Type is required")
  private String type;
  
  @NotBlank(message = "Age is required")
  @Max(value = 30, message = "Age must not exceed 30")
  private int age;
  
  @NotBlank(message = "Weight is required")
  @DecimalMin(value = "0.01", message = "Weight cannot be too small")
  private double weight;
  
  public Pet() {}
  
  public Pet(String name, String type, int age, double weight) {
    super();
    this.name = name;
    this.type = type;
    this.age = age;
    this.weight = weight;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  public double getWeight() {
    return weight;
  }
  
  public void setWeight(double weight) {
    this.weight = weight;
  }
}
