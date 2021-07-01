package football.ticket.app.dao;

import java.util.List;
import football.ticket.app.model.Order;
import football.ticket.app.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
