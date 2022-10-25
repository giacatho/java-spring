package sg.edu.nus.iss.validator.demo.model;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

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
}
