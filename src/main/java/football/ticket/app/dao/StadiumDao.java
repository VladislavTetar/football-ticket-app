package football.ticket.app.dao;

import football.ticket.app.model.Stadium;
import java.util.List;
import java.util.Optional;

public interface StadiumDao extends GenericDao<Stadium> {
    Optional<Stadium> get(Long id);

    List<Stadium> getAll();
}
