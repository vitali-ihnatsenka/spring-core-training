package by.epam.training.service.discount;

import by.epam.training.domain.EventShow;
import by.epam.training.domain.User;

/**
 * Created by Vitali on 25.10.2015.
 */
public class EveryTenTicketStrategy implements DiscountStrategy{
    private int discountValue;

    @Override
    public int getDiscount(User user, EventShow show) {
        if(user.getTickets().size() == 9){
            return discountValue;
        }
        return 0;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }
}
