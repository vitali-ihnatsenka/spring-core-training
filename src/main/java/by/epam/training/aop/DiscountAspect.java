package by.epam.training.aop;

import by.epam.training.dao.CounterDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 */
@Aspect
public class DiscountAspect {
    @Pointcut("execution(* by.epam.training.service.DiscountStrategy.getDiscount(..))")
    private void eventByNameMethod(){}

    private CounterDao counterDao;

    @Before("eventByNameMethod()")
    public void countBefore(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        counterDao.incrementCounter(name);

    }

    public void setCounterDao(CounterDao counterDao) {
        this.counterDao = counterDao;
    }
}
