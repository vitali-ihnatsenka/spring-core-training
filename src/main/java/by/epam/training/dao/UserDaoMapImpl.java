package by.epam.training.dao;

import by.epam.training.dao.exception.TicketBookedException;
import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;
import by.epam.training.service.DataMapService;

import java.util.*;

/**
 * Created by Vitali Ihnatsenka on 23.10.2015.
 */
public class UserDaoMapImpl implements UserDao{
    static private Map<Integer, User> userMap = new HashMap<Integer, User>();
    static private Map<Ticket, User> ticketUserMap = new HashMap<Ticket, User>();
    static private Map<Integer, Ticket> bookedTicketMap = new HashMap<Integer, Ticket>();
    private DataMapService dataMapService;

    @Override
    public void register(String email, String name, Date birthday) {
        dataMapService.register(userMap, new User(name, email, birthday));
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
        List<Ticket> tickets  = new ArrayList<Ticket>();
        for(Map.Entry<Ticket, User> entry : ticketUserMap.entrySet()){
            if(entry.getValue().equals(user)){
                tickets.add(entry.getKey());
            }
        }
        return tickets;
    }

    @Override
    public int getUserId(User user) {
        return dataMapService.getObjectId(userMap, user);
    }

    @Override
    public void addTicket(User user, Ticket ticket) {
        if(bookedTicketMap.containsValue(ticket)){
            throw new TicketBookedException(ticket);
        }
        dataMapService.register(bookedTicketMap, ticket);
        ticketUserMap.put(ticket, user);
    }

    public void setDataMapService(DataMapService dataMapService) {
        this.dataMapService = dataMapService;
    }
}
