package football.ticket.app.service;

import football.ticket.app.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
