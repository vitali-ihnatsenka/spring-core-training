package by.epam.training.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali Ihnatsenka on 20.10.2015.
 */
public class User {
    private String email;
    private String name;
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
}
