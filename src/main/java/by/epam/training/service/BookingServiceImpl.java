package by.epam.training.service;

import by.epam.training.domain.Event;
import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class BookingServiceImpl implements BookingService {

    @Override
    public int getTicketPrice(int eventId, Date date, int seat, int userId) {
        return 0;
    }

    @Override
    public void bookTicket(Ticket ticket, User user) {

    }

    @Override
    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        return null;
    }
}
