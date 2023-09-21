package sg.nus.iss.rest.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.rest.web.model.Course;
import sg.nus.iss.rest.web.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
  @Resource
  private CourseRepository courseRepository;
  
  @Override
  public List<Course> findAllCourses() {
    return courseRepository.findAll();
  }
}
