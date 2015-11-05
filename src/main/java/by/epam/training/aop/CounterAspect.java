package by.epam.training.aop;


import by.epam.training.dao.CounterDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 */
@Aspect
public class CounterAspect {
    @Pointcut("execution(* by.epam.training.service.EventService.getByName(..))")
    private void eventByNameMethod(){}
    @Pointcut("execution(* by.epam.training.service.BookingService.getTicketPrice(..))")
    private void getTicketPriceMethod(){}
    @Pointcut("execution(* by.epam.training.service.BookingService.bookTicket(..))")
    private void bookTicketMethod(){}
    @Pointcut("eventByNameMethod() || getTicketPriceMethod() || bookTicketMethod()")
    private void allCountedMethods(){}

    private CounterDao counterDao;

    @Before("allCountedMethods()")
    public void countBefore(JoinPoint joinPoint){
        counterDao.incrementCounter(joinPoint.getSignature().getName());
    }


    public void setCounterDao(CounterDao counterDao) {
        this.counterDao = counterDao;
    }
}
