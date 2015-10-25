package by.epam.training.service.discount;

import by.epam.training.domain.EventShow;
import by.epam.training.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vitali on 23.10.2015.
 */
public class DiscountServiceImpl implements DiscountService{
    private List<DiscountStrategy> discountStrategyList;

    @Override
    public int getDiscount(User user, EventShow eventShow) {
        List<Integer> discounts = new ArrayList<Integer>();
        for(DiscountStrategy discountStrategy : discountStrategyList){
            discounts.add(discountStrategy.getDiscount(user, eventShow));
        }
        return Collections.max(discounts);
    }

    public void setDiscountStrategyList(List<DiscountStrategy> discountStrategyList) {
        this.discountStrategyList = discountStrategyList;
    }
}
