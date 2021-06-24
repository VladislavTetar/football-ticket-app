package football.ticket.app.dao.impl;

import football.ticket.app.dao.AbstractDao;
import football.ticket.app.dao.UserDao;
import football.ticket.app.exception.DataProcessingException;
import football.ticket.app.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User u "
                    + "WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get user by email: " + email, e);
        }
    }

    @Override
    public Optional<User> getById(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> getUserQuery = session.createQuery(
                    "FROM User u WHERE u.id = :id", User.class);
            getUserQuery.setParameter("id", userId);
            return Optional.ofNullable(getUserQuery.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't get user by id: " + userId, e);
        }
    }
}
