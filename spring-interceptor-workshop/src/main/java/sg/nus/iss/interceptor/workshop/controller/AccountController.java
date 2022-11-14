package sg.nus.iss.interceptor.workshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
  @GetMapping("/edit") 
  public String edit(HttpSession session) {
    return "account-edit";
  }
  
  @GetMapping("/delete") 
  public String delete(HttpSession session) { 
    return "account-delete";
  }
}