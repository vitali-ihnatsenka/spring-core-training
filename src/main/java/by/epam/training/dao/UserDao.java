package by.epam.training.dao;

import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;

import java.util.List;

/**
 * Created by Vitali Ihnatsenka on 23.10.2015.
 */
public interface UserDao {
    void register(User user);
    void remove(int id);
    User getById(int id);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    List<Ticket> getBookedTickets(int userId);
}
