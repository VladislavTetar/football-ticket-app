package football.ticket.app.service;

import football.ticket.app.model.Order;
import football.ticket.app.model.ShoppingCart;
import football.ticket.app.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
