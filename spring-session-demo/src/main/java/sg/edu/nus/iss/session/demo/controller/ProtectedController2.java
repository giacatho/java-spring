package sg.edu.nus.iss.session.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProtectedController2 {
  @Controller
  @RequestMapping("/protected2")
  public class ProtectedController1 {
    @RequestMapping("/method21")
    public String method21(HttpSession sessionObj) {
      String username = (String) sessionObj.getAttribute("username");
      if (username == null) {
        return "redirect:/common/login";
      }
      
      // Method implementation omitted
      return "content21";
    }
  }
}
