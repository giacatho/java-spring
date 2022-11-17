package sg.edu.nus.iss.validator.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.validator.demo.model.Course;
import sg.edu.nus.iss.validator.demo.validator.CourseValidator;

@Controller
public class CourseController {
  @Autowired
  private CourseValidator courseValidator;
  
  @InitBinder
  private void initCourseBinder(WebDataBinder binder) {
    System.out.println("---- CourseValidator initCourseBinder() -----");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    
    binder.addValidators(courseValidator);
  }
  
  @GetMapping("/course/create")
  public ModelAndView create() { 
    ModelAndView mav = new ModelAndView("course-new");
    mav.addObject("course", new Course());
    return mav;
  }
  
  @PostMapping("/course/create")
  public String create(@Valid @ModelAttribute Course course, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "course-new";
    }
    
    return "course-new-success";
  }
  
}
