package football.ticket.app.service;

import football.ticket.app.model.GameSession;
import java.time.LocalDate;
import java.util.List;

public interface GameSessionService {
    List<GameSession> findAvailableSessions(Long movieId, LocalDate date);

    GameSession get(Long id);

    GameSession add(GameSession session);

    GameSession update(GameSession gameSession);

    boolean remove(Long id);
}
