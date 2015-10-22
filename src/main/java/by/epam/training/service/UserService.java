package by.epam.training.service;

import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public interface UserService {
    void register(User user);
    void remove(long id);
    User getByID(long id);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    List<Ticket>  getBookedTickets(long userID);
}
