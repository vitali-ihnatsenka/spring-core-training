package by.epam.training.service;

import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {

    }

    @Override
    public void remove(long id) {

    }

    @Override
    public User getByID(long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(long userID) {
        return null;
    }
}
