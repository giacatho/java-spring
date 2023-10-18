package sg.nus.iss.dabajdbc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.dabajdbc.demo.model.User;
import sg.nus.iss.dabajdbc.demo.repository.UserRepository;

@SpringBootApplication
public class SpringDatajdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajdbcDemoApplication.class, args);
	}

	@Bean
  CommandLineRunner commandLineRun(UserRepository userRepository) {
    return args -> {
      List<User> myUsers;
      Optional<User> myUser;
      
      System.out.println("---- Generate users");
      List<User> userList = new ArrayList<>();
      userList.add(new User("john"));
      userList.add(new User("mike"));
      userList.add(new User("james"));
      userList.add(new User("katie"));
      userList.add(new User("beth", false));
      userList.add(new User("julius", false));
      userRepository.saveAll(userList);
      
      System.out.println("---- Find all users");
      myUsers = userRepository.findAll();
      myUsers.forEach(user -> System.out.println(user));
      
      System.out.println("---- Find user with id = 2");
      myUser = userRepository.findById(Long.parseLong("2"));
      if (myUser.isPresent()) {
        System.out.println(myUser);
      } else {
        System.out.println("No user with id = 2");
      }
      
      System.out.println("---- Find user with username = katie");
      myUser = userRepository.findByUsername("katie");
      if (myUser.isPresent()) {
        System.out.println(myUser);
      } else {
        System.out.println("No user with username = katie");
      }
      
      System.out.println("---- Find non-active users");
      myUsers = userRepository.findByActive(false);
      myUsers.forEach(user -> System.out.println(user));
      
      System.out.println("---- Activiate user with id = 5");
      userRepository.updateActive(true, 5);
      
      System.out.println("---- Find active users");
      myUsers = userRepository.findByActive(true);
      myUsers.forEach(user -> System.out.println(user));
    };
	}

}
