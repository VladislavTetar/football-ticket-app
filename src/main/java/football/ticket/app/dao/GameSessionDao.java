package football.ticket.app.dao;

import football.ticket.app.model.GameSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GameSessionDao extends GenericDao<GameSession> {
    List<GameSession> findAvailableSessions(Long movieId, LocalDate date);

    Optional<GameSession> get(Long id);

    GameSession update(GameSession gameSession);

    boolean remove(Long id);
}
