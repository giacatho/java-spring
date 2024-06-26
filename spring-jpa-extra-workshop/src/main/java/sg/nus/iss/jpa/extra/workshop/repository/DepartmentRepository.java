package sg.nus.iss.jpa.extra.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.nus.iss.jpa.extra.workshop.model.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
  /* This section contains the solution queries 
   * for JPA Extra workshop
   */
  @Query("SELECT d.name,  COUNT(s), AVG(s.cap) " + 
         "FROM Department d " +
         "   JOIN d.students s  " +
         "GROUP BY d ")
  public List findDepartmentsWithAverageCAP();
  
  
  /* This section contains sample queries in the lectures */
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
