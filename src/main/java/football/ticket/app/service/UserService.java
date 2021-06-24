package football.ticket.app.service;

import football.ticket.app.model.User;

public interface UserService {
    User add(User user);

    User findByEmail(String email);

    User getById(Long userId);
}
