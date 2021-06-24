package football.ticket.app.dao;

import football.ticket.app.model.Game;
import java.util.List;
import java.util.Optional;

public interface GameDao extends GenericDao<Game> {
    Optional<Game> get(Long id);

    List<Game> getAll();
}
