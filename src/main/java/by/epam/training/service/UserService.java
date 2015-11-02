package by.epam.training.service;

import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public interface UserService {
    void register(User user);
    void remove(int id);
    User getByID(int id);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    // FIXME: 0.5%: never used
    List<Ticket>  getBookedTickets(int userID);
    int getUserId(User user);
}
