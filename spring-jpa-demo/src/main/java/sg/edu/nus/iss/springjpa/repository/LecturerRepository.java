package sg.edu.nus.iss.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.iss.springjpa.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

}
