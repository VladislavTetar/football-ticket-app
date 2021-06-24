package football.ticket.app.service.impl;

import football.ticket.app.dao.GameDao;
import football.ticket.app.model.Game;
import football.ticket.app.service.GameService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public Game add(Game game) {
        return gameDao.add(game);
    }

    @Override
    public Game get(Long id) {
        return gameDao.get(id).get();
    }

    @Override
    public List<Game> getAll() {
        return gameDao.getAll();
    }
}
