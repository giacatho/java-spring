package sg.nus.iss.i18n.demo.switchlanguage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
  @GetMapping("/welcome")
  public String welcome() {
    return "welcome";
  }
  
  @GetMapping("/change-language")
  public String changeLanguage() {
    return "change-language";
  }
}