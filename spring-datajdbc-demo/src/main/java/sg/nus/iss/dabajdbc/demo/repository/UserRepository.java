package sg.nus.iss.dabajdbc.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.nus.iss.dabajdbc.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    Optional<User> findByUsername(String username);
    
    @Query("SELECT * FROM users WHERE active = :active")
    List<User> findByActive(@Param("active") boolean active);

    @Modifying
    @Query("UPDATE users SET active = :new_active WHERE id = :id")
    int updateActive(@Param("new_active") boolean active, @Param("id")long id);
}