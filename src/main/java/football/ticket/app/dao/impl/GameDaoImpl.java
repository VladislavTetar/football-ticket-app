package football.ticket.app.dao.impl;

import football.ticket.app.dao.AbstractDao;
import football.ticket.app.dao.GameDao;
import football.ticket.app.exception.DataProcessingException;
import football.ticket.app.model.Game;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl extends AbstractDao<Game> implements GameDao {
    public GameDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Game> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Game.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a game by id: " + id, e);
        }
    }

    @Override
    public List<Game> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Game> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Game.class);
            criteriaQuery.from(Game.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all games", e);
        }
    }
}
