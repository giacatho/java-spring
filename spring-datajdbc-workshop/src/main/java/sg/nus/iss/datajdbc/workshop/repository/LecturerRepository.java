package sg.nus.iss.datajdbc.workshop.repository;

import org.springframework.data.repository.CrudRepository;

import sg.nus.iss.datajdbc.workshop.model.Lecturer;

public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {

}
