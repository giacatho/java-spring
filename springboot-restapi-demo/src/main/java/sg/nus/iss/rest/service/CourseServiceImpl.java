package sg.nus.iss.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import sg.nus.iss.rest.model.Course;
import sg.nus.iss.rest.repository.CourseRepository;

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
  public Optional<Course> findCourse(int id) {
    return courseRepository.findById(id);
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
  public void deleteCourse(int id) {
    courseRepository.deleteById(id);
  }
  
}
