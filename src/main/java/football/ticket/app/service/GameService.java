package football.ticket.app.service;

import football.ticket.app.model.Game;
import java.util.List;

public interface GameService {
    Game add(Game game);

    Game get(Long id);

    List<Game> getAll();
}
