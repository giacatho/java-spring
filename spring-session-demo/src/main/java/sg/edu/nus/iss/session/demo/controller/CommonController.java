package sg.edu.nus.iss.session.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.session.demo.model.User;

@Controller
@RequestMapping("/common")
public class CommonController {
  @GetMapping("/login")
  public String login(Model model, HttpSession sessionObj) {
    String username = (String) sessionObj.getAttribute("username");
    System.out.println("username: " + username);
    if (username != null) {
      return "redirect:/protected/list-users";
    }

    System.out.println("In login()");
    User myUser = new User();
    model.addAttribute("user", myUser);

    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute("user") User user, HttpServletRequest request) {
    HttpSession sessionObj = request.getSession();
    if (user.getUsername().equalsIgnoreCase("dipsa") || user.getUsername().equalsIgnoreCase("student")) {
      sessionObj.setAttribute("username", user.getUsername());
      return "redirect:/protected/list-users";
    }

    return "login";
  }

  @RequestMapping("/logout")
  public String logout(HttpSession sessionObj) {
    sessionObj.removeAttribute("username");

    // sessionObj.invalidate();

    return "redirect:/common/login";
  }

}
