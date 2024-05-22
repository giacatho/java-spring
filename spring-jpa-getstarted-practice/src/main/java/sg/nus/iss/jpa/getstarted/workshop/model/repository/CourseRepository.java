package sg.nus.iss.jpa.getstarted.workshop.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.jpa.getstarted.workshop.model.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
