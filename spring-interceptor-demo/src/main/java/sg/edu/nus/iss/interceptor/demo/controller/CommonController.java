package sg.edu.nus.iss.interceptor.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/common")
public class CommonController {
  @GetMapping("/about")
  public String about() {
      return "about";
  }

}
