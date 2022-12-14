package sg.nus.iss.interceptor.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
  @GetMapping("/list")
  public String list() {
    return "product-list";
  }
  
  @GetMapping("/create")
  public String create() {
    return "product-create";
  }
}
