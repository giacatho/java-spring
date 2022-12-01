package sg.edu.nus.iss.session.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/protected1")
public class ProtectedController1 {
  @RequestMapping("/method11")
  public String method11(HttpSession sessionObj) {
    if (!SessionHelper.isLoggedIn(sessionObj)) {
      return "redirect:/common/login"; 
    }

    // Method implementation omitted
    return "content11";
  }
  
  @RequestMapping("/method12")
  public String method12(HttpSession sessionObj) {
    if (!SessionHelper.isLoggedIn(sessionObj)) {
      return "redirect:/common/login"; 
    }
    
    // Method implementation omitted
    return "content12";
  }
  
}
