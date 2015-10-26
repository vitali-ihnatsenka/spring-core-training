package by.epam.training.service;

import by.epam.training.domain.*;
import by.epam.training.service.discount.DiscountService;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class BookingServiceImpl implements BookingService {
    private DiscountService discountService;

    @Override
    public int getTicketPrice(EventShow eventShow, int seat, User user) {
        int price = eventShow.getEvent().getBasePrice();
        List<Integer> vipSeats = eventShow.getAuditorium().getVipSeats();
        int discount = discountService.getDiscount(user, eventShow);
        if(vipSeats.contains(seat)){
            price *= 1.2;
        }
        price = (price * (100 - discount))/100;
        return price;
    }

    @Override
    public void bookTicket(Ticket ticket, User user) {
        user.addTicket(ticket);
    }

    @Override
    public List<Ticket> getTicketsForEvent(EventShow eventShow) {
        return null;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }
}
