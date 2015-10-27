package by.epam.training.dao;

import by.epam.training.domain.Ticket;

/**
 * Created by Vitali on 27.10.2015.
 */
public interface TicketDao {
    void bookTicket(Ticket ticket);
    boolean isBooked(Ticket ticket);
}
