package by.epam.training.service;

import by.epam.training.dao.TicketDao;
import by.epam.training.dao.UserDao;
import by.epam.training.domain.*;
import by.epam.training.service.discount.DiscountService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class BookingServiceImpl implements BookingService {
    private DiscountService discountService;
    private TicketDao ticketDao;
    private UserDao userDao;

    @Override
    public int getTicketPrice(EventShow eventShow, int seat, User user) {
        int price = eventShow.getEvent().getBasePrice();
        List<Integer> vipSeats = eventShow.getAuditorium().getVipSeats();
        int discount = discountService.getDiscount(user, eventShow);
        if(vipSeats.contains(seat)){
            price *= 1.2;
        }
        if(eventShow.getEvent().getRating().equals(Rating.HIGH)){
            price *= 1.2;
        }
        price = (price * (100 - discount))/100;
        return price;
    }

    /**
     * @throws by.epam.training.dao.exception.TicketIsBookedException when ticket is already booked
     */
    @Override
    public void bookTicket(Ticket ticket, User user) {
        ticketDao.bookTicket(ticket);
        userDao.addTicket(user, ticket);
    }

    //EventShow object includes date of event
    @Override
    public List<Ticket> getTicketsForEvent(EventShow eventShow) {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int i = 0; i < eventShow.getAuditorium().getNumberOfSeats() ; i++) {
            tickets.add(new Ticket(eventShow, i));
        }
        return tickets;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
