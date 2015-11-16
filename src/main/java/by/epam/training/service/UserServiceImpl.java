package by.epam.training.service;

import by.epam.training.dao.UserDao;
import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void register(String email, String name, Date birthday) {
        System.out.println("-------Register user: " + new User(email, name, birthday)  + " ----------");
        userDao.register(email, name, birthday);
    }

    @Override
    public void remove(int id) {
        System.out.println("-------Remove  user with id: " + id + " ----------");
        userDao.remove(id);
    }

    @Override
    public User getByID(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }

    @Override
    public List<Ticket> getBookedTickets(int userID) {
        return userDao.getBookedTickets(userID);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
