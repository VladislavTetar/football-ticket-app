package football.ticket.app.dao;

import java.util.Optional;
import football.ticket.app.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(Role.Roles role);
}
