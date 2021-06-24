package football.ticket.app.dao.impl;

import football.ticket.app.dao.AbstractDao;
import football.ticket.app.dao.GameSessionDao;
import football.ticket.app.exception.DataProcessingException;
import football.ticket.app.model.GameSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class GameSessionDaoImpl extends AbstractDao<GameSession> implements GameSessionDao {
    private static final LocalTime END_OF_DAY = LocalTime.of(23, 59, 59);

    public GameSessionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<GameSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<GameSession> criteriaQuery =
                    criteriaBuilder.createQuery(GameSession.class);
            Root<GameSession> root = criteriaQuery.from(GameSession.class);
            Predicate moviePredicate = criteriaBuilder.equal(root.get("game"), movieId);
            Predicate datePredicate = criteriaBuilder.between(root.get("showTime"),
                    date.atStartOfDay(), date.atTime(END_OF_DAY));
            Predicate allConditions = criteriaBuilder.and(moviePredicate, datePredicate);
            criteriaQuery.select(root).where(allConditions);
            root.fetch("game");
            root.fetch("stadium");
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get available sessions for game with id: "
                    + movieId + " for date: " + date, e);
        }
    }

    @Override
    public Optional<GameSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(GameSession.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a game session by id: " + id, e);
        }
    }

    @Override
    public GameSession update(GameSession gameSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(gameSession);
            transaction.commit();
            return gameSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not update game session with id "
                    + gameSession.getId() + ". ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean remove(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.createQuery("delete from GameSession where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Could not remove game session by id "
                    + id + ". ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
