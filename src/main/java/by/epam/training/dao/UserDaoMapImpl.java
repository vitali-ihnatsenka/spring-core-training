package by.epam.training.dao;

import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;
import by.epam.training.service.DataMapService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitali Ihnatsenka on 23.10.2015.
 */
public class UserDaoMapImpl implements UserDao{
    static private Map<Integer, User> userMap = new HashMap<Integer, User>();
    private DataMapService dataMapService;

    @Override
    public void register(User user) {
        dataMapService.register(userMap, user);
    }

    @Override
    public void remove(int id) {
        userMap.remove(id);
    }

    @Override
    public User getById(int id) {
        return userMap.get(id);
    }

    @Override
    public User getUserByEmail(String email) {
        for(User user: userMap.values()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        List<User> users = new ArrayList<User>();
        for(User user: userMap.values()){
            if(user.getName().equals(name)){
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public List<Ticket> getBookedTickets(int userId) {
        User  user = userMap.get(userId);
        return user.getTickets();
    }

    @Override
    public int getUserId(User user) {
        return dataMapService.getObjectId(userMap, user);
    }

    @Override
    public void addTicket(User user, Ticket ticket) {
        user.addTicket(ticket);
    }

    public void setDataMapService(DataMapService dataMapService) {
        this.dataMapService = dataMapService;
    }
}
