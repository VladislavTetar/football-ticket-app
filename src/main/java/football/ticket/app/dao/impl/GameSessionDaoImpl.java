package football.ticket.app.dao.impl;

import java.time.LocalDate;
import java.util.List;
import football.ticket.app.dao.AbstractDao;
import football.ticket.app.dao.GameSessionDao;
import football.ticket.app.exception.DataProcessingException;
import football.ticket.app.model.GameSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GameSessionDaoImpl extends AbstractDao<GameSession> implements GameSessionDao {
    public GameSessionDaoImpl(SessionFactory factory) {
        super(factory, GameSession.class);
    }

    @Override
    public List<GameSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<GameSession> getAvailableSessions = session.createQuery(
                    "FROM GameSession WHERE id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date", GameSession.class);
            getAvailableSessions.setParameter("id", movieId);
            getAvailableSessions.setParameter("date", date.toString());
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for game with id "
                    + movieId + " and show date " + date + " not found", e);
        }
    }
}
