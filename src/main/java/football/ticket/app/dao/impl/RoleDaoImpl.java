package football.ticket.app.dao.impl;

import java.util.Optional;
import football.ticket.app.dao.AbstractDao;
import football.ticket.app.dao.RoleDao;
import football.ticket.app.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(Role.Roles role) {
        try (Session session = factory.openSession()) {
            Query<Role> getRoleQuery = session.createQuery("FROM Role r "
                    + "WHERE r.role = :role", Role.class);
            getRoleQuery.setParameter("role", role);
            return Optional.ofNullable(getRoleQuery.getSingleResult());
        }
    }
}
