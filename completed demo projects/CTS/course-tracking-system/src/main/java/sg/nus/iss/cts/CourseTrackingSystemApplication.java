package sg.nus.iss.cts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.cts.model.Role;
import sg.nus.iss.cts.repository.RoleRepository;

@SpringBootApplication
public class CourseTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseTrackingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(RoleRepository roleRepository) {
    return (args) -> {
        // save a couple of Roles
      roleRepository.save(new Role("admin", "Administrator", "System administrator"));
      roleRepository.save(new Role("staff", "Staff", "Staff members"));
      roleRepository.save(new Role("manager", "Manager", "Manager"));
    };
	}
}
