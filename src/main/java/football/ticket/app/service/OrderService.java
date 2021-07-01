package football.ticket.app.service;

import java.util.List;
import football.ticket.app.model.Order;
import football.ticket.app.model.ShoppingCart;
import football.ticket.app.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
