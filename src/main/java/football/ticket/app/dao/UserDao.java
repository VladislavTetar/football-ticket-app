package football.ticket.app.dao;

import football.ticket.app.model.User;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByEmail(String email);

    Optional<User> getById(Long userId);
}
