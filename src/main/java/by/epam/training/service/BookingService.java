package by.epam.training.service;

import by.epam.training.domain.Event;
import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public interface BookingService {
    int getTicketPrice(int eventId, Date date, int seat, int userId);
    void bookTicket(Ticket ticket, User user);
    List<Ticket> getTicketsForEvent(Event event, Date date);
}
