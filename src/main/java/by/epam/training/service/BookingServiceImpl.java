package by.epam.training.service;

import by.epam.training.dao.UserDao;
import by.epam.training.dao.exception.TicketBookedException;
import by.epam.training.domain.*;
import by.epam.training.service.discount.DiscountService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class BookingServiceImpl implements BookingService {
    private DiscountService discountService;
    private UserDao userDao;

    @Override
    public int getTicketPrice(Ticket ticket, User user) {
        if(ticket.isLucky()){
            return 0;
        }
        EventShow eventShow = ticket.getEventShow();
        int price = eventShow.getEvent().getBasePrice();
        List<Integer> vipSeats = eventShow.getAuditorium().getVipSeats();
        int discount = discountService.getDiscount(user, eventShow);
        if(vipSeats.contains(ticket.getSeatNumber())){
            price *= 1.2;
        }
        if(eventShow.getEvent().getRating().equals(Rating.HIGH)){
            price *= 1.2;
        }
        price = (price * (100 - discount))/100;
        return price;
    }

    /**
     * @throws TicketBookedException when ticket is already booked
     */
    @Override
    public void bookTicket(Ticket ticket, User user) {
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

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
