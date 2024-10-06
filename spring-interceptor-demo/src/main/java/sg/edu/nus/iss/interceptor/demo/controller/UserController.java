package sg.edu.nus.iss.interceptor.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
// This is a dummy class, doing nothing, and is only for demo purpose
public class UserController {
  @GetMapping("/profile")
  public String viewProfile() {
    return "profile";
  }
  
  @PostMapping("/update-email")
  public String updateEmail() {
    return "email";
  }
  
  @PostMapping("/update-notifications")
  public String updateNotifications() {
    return "notifications";
  }
}
