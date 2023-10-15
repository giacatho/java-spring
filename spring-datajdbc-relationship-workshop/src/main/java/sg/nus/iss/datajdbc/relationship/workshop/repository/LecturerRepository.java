package sg.nus.iss.datajdbc.relationship.workshop.repository;

import org.springframework.data.repository.CrudRepository;

import sg.nus.iss.datajdbc.relationship.workshop.model.Lecturer;

public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {

}
