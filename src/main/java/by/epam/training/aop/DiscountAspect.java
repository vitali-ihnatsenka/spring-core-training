package by.epam.training.aop;

import by.epam.training.dao.CounterDao;
import by.epam.training.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 */
@Aspect
public class DiscountAspect {

    private CounterDao counterDao;

    @Before("execution(int getDiscount(..)) && target(by.epam.training.service.discount.DiscountStrategy) && args(user,..)")
    public void countBefore(JoinPoint joinPoint, User user){
        // FIXME: 2%: count how many times each discount was given total and for specific user
        // it means that we need have separate counter for each DiscountStrategy
        String name = joinPoint.getSignature().getName();
        counterDao.incrementCounter(name);
        counterDao.incrementCounter(name + "-" + user.getEmail());
    }

    public void setCounterDao(CounterDao counterDao) {
        this.counterDao = counterDao;
    }
}
