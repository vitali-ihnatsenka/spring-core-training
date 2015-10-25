package by.epam.training.service.discount;

import by.epam.training.domain.EventShow;
import by.epam.training.domain.User;

import java.util.Calendar;

/**
 * Created by Vitali on 25.10.2015.
 */
public class BirthdayStrategy implements DiscountStrategy {

    private int discountValue;

    @Override
    public int getDiscount(User user, EventShow show) {
        Calendar showDay = Calendar.getInstance();
        Calendar birthday = Calendar.getInstance();
        showDay.setTime(show.getDate());
        birthday.setTime(user.getBirthday());
        if(showDay.get(Calendar.MONTH) == birthday.get(Calendar.MONTH) && showDay.get(Calendar.DAY_OF_MONTH) == birthday.get(Calendar.DAY_OF_MONTH)){
            return discountValue;
        }
        return 0;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }
}
