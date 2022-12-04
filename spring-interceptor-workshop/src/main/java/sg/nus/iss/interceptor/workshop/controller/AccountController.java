package sg.nus.iss.interceptor.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
  @GetMapping("/edit") 
  public String edit() {
    return "account-edit";
  }
  
  @GetMapping("/delete") 
  public String delete() { 
    return "account-delete";
  }
}
