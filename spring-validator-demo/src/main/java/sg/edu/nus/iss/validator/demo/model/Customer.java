package sg.edu.nus.iss.validator.demo.model;

import java.util.Date;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

//Note: currently, this class is only here as demo code and is not used in other places in this project.
public class Customer {
  @Size(min = 2, max = 30)
  private String name;

  @NotEmpty
  @Email
  private String email;

  @NotNull
  @Min(18)
  @Max(100)
  private Integer age;

  @NotNull
  private String gender;

  @DateTimeFormat(pattern = "MM/dd/yyyy")
  @NotNull
  @Past
  private Date birthday;
  
  @CreditCardNumber
  private String creditCardNumber;
  
  @Digits(integer = 3, fraction = 0)
  private String creditCardCVV;
  
  private String oldPassword;
  
  private String newPassword;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public String getCreditCardCVV() {
    return creditCardCVV;
  }

  public void setCreditCardCVV(String creditCardCVV) {
    this.creditCardCVV = creditCardCVV;
  }

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }
}
