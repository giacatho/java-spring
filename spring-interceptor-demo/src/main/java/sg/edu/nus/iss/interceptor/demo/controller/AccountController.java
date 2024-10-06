package sg.edu.nus.iss.interceptor.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
  @GetMapping("/balance")
  public String viewBalance() {
    return "account-balance";
  }
  
  @GetMapping("/withdraw")
  public String withdraw() {
    return "account-withdraw";
  }
  
  @GetMapping("/transfer")
  public String transfer() {
    return "account-transfer";
  }
}
