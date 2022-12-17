package sg.nus.iss.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.iss.courses.model.Course;
import sg.nus.iss.courses.service.CourseService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CourseController {
  @Autowired
  private CourseService courseService;
  
  @GetMapping("/courses")
  public List<Course> getAllCourses() {
    return courseService.findAllCourses();
  }
  
  @GetMapping("/courses/{id}")
  public ResponseEntity<Course> getCourseById(int id) {
    Optional<Course> optCourse = courseService.findCourse(id);
    
    if (optCourse.isPresent()) {
      Course course = optCourse.get();
      return new ResponseEntity<Course>(course, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @PostMapping("/courses")
  public ResponseEntity<Course> createCourse(@RequestBody Course inCourse) {
    try {
      Course retCourse = courseService.createCourse(inCourse);      
      
      return new ResponseEntity<Course>(retCourse, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
  }
  
  @PutMapping("/courses/{id}")
  public ResponseEntity<Course> editCourse(@PathVariable("id") int id, @RequestBody Course inCourse) {
    Optional<Course> optCourse = courseService.findCourse(id);
    
    if (optCourse.isPresent()) {
      // Update the managed course obj
      Course course = optCourse.get();
      
      course.setCode(inCourse.getCode());
      course.setName(inCourse.getName());
      course.setDescription(inCourse.getDescription());
      
      Course updatedCourse = courseService.updateCourse(course);
      
      return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/courses/{id}")
  public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") int id) {
    try {
      courseService.deleteCourse(id);
      return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
    }
  }
  
}
