package football.ticket.app.dao.impl;

import football.ticket.app.dao.AbstractDao;
import football.ticket.app.dao.StadiumDao;
import football.ticket.app.model.Stadium;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StadiumDaoImpl extends AbstractDao<Stadium> implements StadiumDao {
    public StadiumDaoImpl(SessionFactory factory) {
        super(factory, Stadium.class);
    }
}
