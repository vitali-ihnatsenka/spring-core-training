package by.epam.training.dao;

import by.epam.training.dao.exception.TicketIsBookedException;
import by.epam.training.domain.Ticket;
import by.epam.training.service.DataMapService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali on 27.10.2015.
 */
public class TicketDaoMapImpl implements TicketDao {
    private static Map<Integer, Ticket> booketTickets = new HashMap<Integer, Ticket>();
    private DataMapService dataMapService;

    @Override
    public void bookTicket(Ticket ticket) {
        if(booketTickets.values().contains(ticket)){
            throw new TicketIsBookedException(ticket);
        }
        dataMapService.register(booketTickets, ticket);
    }

    @Override
    public boolean isBooked(Ticket ticket) {
        if(booketTickets.values().contains(ticket)){
            return true;
        }
        return false;
    }

    public void setDataMapService(DataMapService dataMapService) {
        this.dataMapService = dataMapService;
    }
}
