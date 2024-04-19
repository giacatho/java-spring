package sg.edu.nus.iss.validator.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.validator.demo.model.User;
import sg.edu.nus.iss.validator.demo.service.UserService;

@Controller
@RequestMapping("/common")
public class CommonController {
  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("user", new User());
    return "login";
  }
  
  @PostMapping("/authenticate")
  public String handleLogin(@Valid @ModelAttribute("user") User inUser, 
        BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "login";
    }
    
    if (!UserService.authenticate(inUser.getUsername(), inUser.getPassword())) {
      return "login";
    }
    
    // authenticate successfully, redirect to next page
    return "login-success";
  }
}
