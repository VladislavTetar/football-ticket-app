package football.ticket.app.dao;

import football.ticket.app.model.ShoppingCart;
import football.ticket.app.model.User;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
