package sg.edu.nus.iss.validator.demo.service;

public class UserService {
  public static boolean authenticate(String username, String password) {
    return username.equalsIgnoreCase("dipsa") &&
        password.equalsIgnoreCase("password");
  }
}
