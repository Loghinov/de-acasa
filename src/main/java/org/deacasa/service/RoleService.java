package org.deacasa.service;

import org.deacasa.entity.Role;
import java.util.List;




public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role saveRole(Role role);

    Role updateRole(Long id, Role role);

    void deleteRole(Long id);

}
