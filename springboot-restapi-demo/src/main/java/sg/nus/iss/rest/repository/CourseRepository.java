package sg.nus.iss.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.rest.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
