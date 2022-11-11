package sg.nus.iss.i18n.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
  @GetMapping("/welcome")
  public String welcome() {
    return "welcome";
  }
  
  @GetMapping("/welcome2")
  public String welcome2() {
    return "welcome2";
  }
}
