package sg.edu.nus.iss.session.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/protected")
public class ProtectedController {
  @GetMapping("/list-users")
  public String listUsers(HttpSession sessionObj, Model model) {
    String username = (String) sessionObj.getAttribute("username");
    System.out.println("username: " + username);
    if (username == null) {
      return "redirect:/common/login";
    }

    model.addAttribute("username", username);
    model.addAttribute("message", "Hello");

    return "list-users";
  }
}
