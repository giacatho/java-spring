package sg.nus.iss.jpql.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.nus.iss.jpql.demo.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
  @Query("SELECT d.name,  COUNT(s), AVG(s.cap) " + 
         "FROM Department d " +
         "   JOIN d.students s  " +
         "GROUP BY d ")
  public List aggregateQuery();
  
  @Query("SELECT d.name,  COUNT(s), AVG(s.cap) " + 
         "FROM Department d " +
         "   JOIN d.students s  " +
         "GROUP BY d " +
         "HAVING COUNT(s) >= 5")
  public List aggregateQueryWithHaving();
}
