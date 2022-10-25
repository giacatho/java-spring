package sg.edu.nus.iss.validator.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.nus.iss.validator.demo.model.Course;

@Component
public class CourseValidator implements Validator {

  /**
   * Validates Course instances or any subclasses of Course
   */
  @Override
  public boolean supports(Class<?> clazz) {
    return Course.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object obj, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "error.code", "Course code is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Course name is required."); 
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "error.startDate", "Start date is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "error.endDate", "End date is required.");
    
    Course course = (Course) obj;  
    if ((course.getStartDate() != null && course.getEndDate() != null) &&
          (course.getStartDate().compareTo(course.getEndDate()) > 0)) {
      errors.rejectValue("endDate", "error.dates", "to date must be > from date");
    }
    
  }

}