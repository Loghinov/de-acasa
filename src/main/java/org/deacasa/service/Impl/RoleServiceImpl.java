package org.deacasa.service.Impl;

import org.deacasa.entity.Role;
import org.deacasa.repository.RoleRepo;
import org.deacasa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private  final RoleRepo roleRepo;
    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo){this.roleRepo=roleRepo;}

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Role not found"));
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Role role1=getRoleById(id);
        role1.setRoleName(role.getRoleName());
        role1.setRoleDescription(role.getRoleDescription());
        return roleRepo.save(role1);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepo.deleteById(id);

    }
}
