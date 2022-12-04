package sg.nus.iss.courses.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.nus.iss.courses.model.Course;
import sg.nus.iss.courses.repository.CourseRepository;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {
  @Resource
  private CourseRepository courseRepository;
  
  @Override
  public List<Course> findAllCourses() {
    return courseRepository.findAll();
  }

  @Override
  public Course findCourse(int id) {
    return courseRepository.findById(id).orElse(null);
  }

  @Transactional(readOnly = false)
  @Override
  public Course createCourse(Course course) {
    return courseRepository.save(course);
  }

  @Transactional(readOnly = false)
  @Override
  public Course updateCourse(Course course) {
    return courseRepository.save(course);
  }

  @Transactional(readOnly = false)
  @Override
  public void removeCourse(int id) {
    courseRepository.deleteById(id);
  }
  
}
