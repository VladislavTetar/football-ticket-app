package football.ticket.app.service;

import football.ticket.app.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(Role.Roles roleName);
}
