package football.ticket.app.service.impl;

import football.ticket.app.dao.RoleDao;
import football.ticket.app.model.Role;
import football.ticket.app.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(Role.Roles roleName) {
        return roleDao.getRoleByName(roleName).get();
    }
}
