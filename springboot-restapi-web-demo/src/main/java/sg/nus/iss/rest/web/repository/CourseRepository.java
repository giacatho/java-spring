package sg.nus.iss.rest.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.rest.web.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
