package football.ticket.app.dao;

public interface GenericDao<T> {
    T add(T entity);
}
