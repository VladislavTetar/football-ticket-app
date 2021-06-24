package football.ticket.app.security;

import football.ticket.app.exception.AuthenticationException;
import football.ticket.app.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
