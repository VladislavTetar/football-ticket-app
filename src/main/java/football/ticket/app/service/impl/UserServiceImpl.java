package football.ticket.app.service.impl;

import football.ticket.app.dao.UserDao;
import football.ticket.app.model.User;
import football.ticket.app.service.UserService;
import football.ticket.app.util.HashUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).get();
    }

    @Override
    public User getById(Long userId) {
        return userDao.getById(userId).get();
    }
}