package by.epam.training.dao.exception;

import by.epam.training.domain.Ticket;

/**
 * Created by Vitali on 27.10.2015.
 */
public class TicketIsBookedException extends RuntimeException {
    private Ticket ticket;

    public TicketIsBookedException(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
