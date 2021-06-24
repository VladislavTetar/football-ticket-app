package football.ticket.app.service.impl;

import football.ticket.app.dao.GameSessionDao;
import football.ticket.app.model.GameSession;
import football.ticket.app.service.GameSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GameSessionServiceImpl implements GameSessionService {
    private final GameSessionDao sessionDao;

    public GameSessionServiceImpl(GameSessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    public List<GameSession> findAvailableSessions(Long movieId, LocalDate date) {
        return sessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public GameSession get(Long id) {
        return sessionDao.get(id).get();
    }

    @Override
    public GameSession add(GameSession session) {
        return sessionDao.add(session);
    }

    @Override
    public GameSession update(GameSession gameSession) {
        return sessionDao.update(gameSession);
    }

    @Override
    public boolean remove(Long id) {
        return sessionDao.remove(id);
    }
}
