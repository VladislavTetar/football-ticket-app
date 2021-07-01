package football.ticket.app.service;

import football.ticket.app.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    User findByEmail(String email);
}
