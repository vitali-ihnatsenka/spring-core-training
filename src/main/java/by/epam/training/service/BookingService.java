package by.epam.training.service;

import by.epam.training.domain.EventShow;
import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public interface BookingService {
    int getTicketPrice(EventShow eventShow, int seat, User user);
    void bookTicket(Ticket ticket, User user);
    List<Ticket> getTicketsForEvent(EventShow eventShow);
}
