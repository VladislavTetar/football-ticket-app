package football.ticket.app.dao.impl;

import football.ticket.app.dao.AbstractDao;
import football.ticket.app.dao.GameDao;
import football.ticket.app.model.Game;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl extends AbstractDao<Game> implements GameDao {
    public GameDaoImpl(SessionFactory factory) {
        super(factory, Game.class);
    }
}
