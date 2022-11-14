package sg.nus.iss.cts.controller.service;

import java.util.List;

import sg.nus.iss.cts.model.Role;
import sg.nus.iss.cts.model.User;

public interface UserService {

  List<User> findAllUsers();
  User findUser(String userId);
  User createUser(User user);
  User changeUser(User user);
  void removeUser(User user);

  List<Role> findRolesForUser(String userId);
  List<String> findRoleNamesForUser(String userId);
  List<String> findManagerNameByUID(String userId);
  User authenticate(String uname, String pwd);
}