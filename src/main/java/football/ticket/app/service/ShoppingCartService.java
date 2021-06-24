package football.ticket.app.service;

import football.ticket.app.model.GameSession;
import football.ticket.app.model.ShoppingCart;
import football.ticket.app.model.User;

public interface ShoppingCartService {
    void addSession(GameSession gameSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clearShoppingCart(ShoppingCart cart);
}
