package football.ticket.app.service.impl;

import football.ticket.app.dao.StadiumDao;
import football.ticket.app.model.Stadium;
import football.ticket.app.service.StadiumService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumDao stadiumDao;

    public StadiumServiceImpl(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
    }

    @Override
    public Stadium add(Stadium stadium) {
        return stadiumDao.add(stadium);
    }

    @Override
    public Stadium get(Long id) {
        return stadiumDao.get(id).get();
    }

    @Override
    public List<Stadium> getAll() {
        return stadiumDao.getAll();
    }
}
