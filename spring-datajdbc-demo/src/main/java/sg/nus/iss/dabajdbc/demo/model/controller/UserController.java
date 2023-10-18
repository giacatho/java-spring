package sg.nus.iss.dabajdbc.demo.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sg.nus.iss.dabajdbc.demo.model.User;
import sg.nus.iss.dabajdbc.demo.repository.UserRepository;

public class UserController {
  @Autowired
  private UserRepository userRepository;
  
  @GetMapping("/list")
  public String getUsers(Model model) {
    Iterable<User> users = userRepository.findAll();
    
    model.addAttribute("users", users);

    return "user-list";
  }
  
}
