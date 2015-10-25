package by.epam.training.service.discount;

import by.epam.training.domain.EventShow;
import by.epam.training.domain.User;

/**
 * Created by Vitali on 25.10.2015.
 */
public interface DiscountStrategy {
    int getDiscount(User user, EventShow show);
}
