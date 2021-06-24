package football.ticket.app.dao;

import football.ticket.app.model.Order;
import football.ticket.app.model.User;
import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrdersHistory(User user);
}
