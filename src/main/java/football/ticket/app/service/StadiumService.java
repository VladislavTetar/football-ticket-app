package football.ticket.app.service;

import football.ticket.app.model.Stadium;
import java.util.List;

public interface StadiumService {
    Stadium add(Stadium stadium);

    Stadium get(Long id);

    List<Stadium> getAll();
}
