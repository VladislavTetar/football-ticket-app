package football.ticket.app.dao;

import football.ticket.app.model.ShoppingCart;
import football.ticket.app.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
