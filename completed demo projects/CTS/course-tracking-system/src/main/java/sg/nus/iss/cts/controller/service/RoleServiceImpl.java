package sg.nus.iss.cts.controller.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sg.nus.iss.cts.model.Role;
import sg.nus.iss.cts.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleRepository roleRepository;
	
	@Transactional
	@Override
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}

	@Transactional
	@Override
	public Role findRole(String roleId) {
		return roleRepository.findById(roleId).orElse(null);
	}

	@Transactional
	@Override
	public Role createRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	@Override
	public Role changeRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> findAllRolesNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findRoleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
