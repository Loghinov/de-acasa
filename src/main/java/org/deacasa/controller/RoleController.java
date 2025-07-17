package org.deacasa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.deacasa.entity.Role;
import org.deacasa.service.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Tag(name="Role", description = "Управление Ролями")
public class RoleController {

    private final RoleService roleService;

    // Получение всех ролей
    @GetMapping("/get-all-roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    // Получение роли по ID
    @GetMapping("/get-role-by-id/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    // Создание новой роли
    @PostMapping("/save-role")
    public Role saveRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    // Обновление существующей роли
    @PutMapping("/update-role/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    // Удаление роли
    @DeleteMapping("/delete-role/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
