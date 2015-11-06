package by.epam.training.aop;

import by.epam.training.domain.Ticket;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Random;

/**
 * Created by Vitali on 06.11.2015.
 */
@Aspect
public class LuckyWinnerAspect {

    //every 4th ticket is lucky
    @Before("execution(void bookTicket(..)) && target(by.epam.training.service.BookingService) && args(ticket,..)")
    public void doLucky(Ticket ticket){
        ticket.setLucky(new Random().nextInt(4) == 1);
    }
}
