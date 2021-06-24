package football.ticket.app.dao.impl;

import football.ticket.app.dao.AbstractDao;
import football.ticket.app.dao.StadiumDao;
import football.ticket.app.exception.DataProcessingException;
import football.ticket.app.model.Stadium;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StadiumDaoImpl extends AbstractDao<Stadium> implements StadiumDao {
    public StadiumDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Stadium> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Stadium.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a stadium by id: " + id, e);
        }
    }

    @Override
    public List<Stadium> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Stadium> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Stadium.class);
            criteriaQuery.from(Stadium.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all stadiums", e);
        }
    }
}
