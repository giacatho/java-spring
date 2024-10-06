package sg.edu.nus.iss.interceptor.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class TimeController {
  @GetMapping("/time/showtime")
  public String showTime(@RequestAttribute long startTime, Model model) {
    // System.out.println("(Controller) Start time: " + startTime);
    
    executeAnOneSecondTask(); // A method that takes 1s to run
    
    model.addAttribute("startTime", startTime);
    
    return "showtime";
  }
  
  private void executeAnOneSecondTask() {
    // Sleep 1 second
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // Cannot sleep
    }
  }
}
