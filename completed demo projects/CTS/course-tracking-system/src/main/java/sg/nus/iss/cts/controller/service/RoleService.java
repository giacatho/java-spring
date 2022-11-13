package sg.nus.iss.cts.controller.service;

import java.util.List;

import sg.nus.iss.cts.model.Role;

public interface RoleService {
	List<Role> findAllRoles();
	Role findRole(String roleId);
	Role createRole(Role role);
	Role changeRole(Role role);
	void removeRole(Role role);
	List<String> findAllRolesNames();
	List<Role> findRoleByName(String name);
}
