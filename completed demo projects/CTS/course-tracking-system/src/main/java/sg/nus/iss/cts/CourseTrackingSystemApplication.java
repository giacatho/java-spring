package sg.nus.iss.cts;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.cts.model.Employee;
import sg.nus.iss.cts.model.Role;
import sg.nus.iss.cts.model.User;
import sg.nus.iss.cts.repository.EmployeeRepository;
import sg.nus.iss.cts.repository.RoleRepository;
import sg.nus.iss.cts.repository.UserRepository;

@SpringBootApplication
public class CourseTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseTrackingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(RoleRepository roleRepository, 
                            EmployeeRepository employeeRepository,
                            UserRepository userRepository) {
    return (args) -> {
      // Add a few Roles
      Role adminRole = roleRepository.save(new Role("admin", "Administrator", "System administrator"));
      Role staffRole = roleRepository.save(new Role("staff", "Staff", "Staff members"));
      Role managerRole = roleRepository.save(new Role("manager", "Manager", "Manager"));
      
      // Add a few Employees
      employeeRepository.save(new Employee("101034", "Admin"));
      employeeRepository.save(new Employee("100027", "Esther Tan"));
      employeeRepository.save(new Employee("312025", "Nguyen Tri Tin", "100027"));
      employeeRepository.save(new Employee("310017", "Cher Wah", "100027"));
      employeeRepository.save(new Employee("110239", "Yuen Kwan", "100027"));
      
      // Add a few Users
      User admin = new User("admin", "admin@nus.edu.sg", "password", "101034");
      User esther = new User("esthertan", "esthertan@nus.edu.sg", "password", "100027");
      User tin = new User("tinnguyen", "tin.nguyen@gmail.com", "password", "312025");
      
      admin.setRoleSet(Arrays.asList(adminRole));
      esther.setRoleSet(Arrays.asList(staffRole, managerRole));
      tin.setRoleSet(Arrays.asList(staffRole));
      
      userRepository.saveAndFlush(admin);
      userRepository.saveAndFlush(esther);
      userRepository.saveAndFlush(tin);
    };
	}
}
