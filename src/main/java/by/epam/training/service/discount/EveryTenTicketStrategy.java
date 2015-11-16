package by.epam.training.service.discount;

import by.epam.training.domain.EventShow;
import by.epam.training.domain.User;
import by.epam.training.service.UserService;

/**
 * Created by Vitali on 25.10.2015.
 */
public class EveryTenTicketStrategy implements DiscountStrategy{
    private int discountValue;
    private UserService userService;

    @Override
    public int getDiscount(User user, EventShow show) {
        if(userService.getBookedTickets(user.getId()).size()%10 == 9){
            return discountValue;
        }
        return 0;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
