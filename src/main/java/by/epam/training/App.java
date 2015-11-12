package by.epam.training;

import by.epam.training.dao.exception.TicketIsBookedException;
import by.epam.training.domain.*;
import by.epam.training.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Vitali Ihnatsenka on 20.10.2015.
 */
public class App {

    // TODO: +2%: nice done

    public static void main(String[] args) throws ParseException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = appContext.getBean("userService", UserService.class);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("------------------USER SERVICE TEST------------------------------------");
        userService.register(new User("Vitali_Ihnatsenka@epam.com", "Vitali", df.parse("14/07/1989")));
        userService.register(new User("Vitali_111@epam.com", "Vitali", df.parse("12/03/1987")));
        userService.register(new User("Viweli_222@epam.com", "Viewdli", df.parse("15/04/1976")));

        User viewdli = userService.getUserByEmail("Viweli_222@epam.com");
        User vitali = userService.getUserByEmail("Vitali_Ihnatsenka@epam.com");
        User vitali111 = userService.getUserByEmail("Vitali_111@epam.com");
        List<User> users = userService.getUsersByName("Vitali");
        System.out.println("\n------------------PRINT USER WITH EMAIL Viweli_222@epam.com------------------------------------");
        System.out.println(vitali);
        System.out.println("\n------------------PRINT USERS WITH NAME Vitali------------------------------------");
        for (User user: users){
            System.out.println(user);
            System.out.println(userService.getUserId(user));
        }
        System.out.println("\n------------------PRINT USER ID FOR Viweli_sadasd@epam.com AND GET USER BY ID------------------------------------");
        int id = userService.getUserId(viewdli);
        System.out.println(id);
        System.out.println(userService.getByID(id));
        userService.remove(id);
        System.out.println("\n------------------PRINT USER WITH ID "+id+"(Expected null)------------------------------------");
        System.out.println(userService.getByID(id));
        System.out.println("\n------------------FINISH USER SERVICE TEST------------------------------------");


        System.out.println("\n\n\n------------------EVENT SERVICE TEST------------------------------------");
        EventService eventService = appContext.getBean("eventService", EventService.class);
        AuditoriumService auditoriumService = appContext.getBean("auditoriumService", AuditoriumService.class);

        eventService.create(new Event("Terminator", 1000, Rating.HIGH));
        eventService.create(new Event("Jacky chan", 500, Rating.LOW));
        eventService.create(new Event("Chuck Norris", 1500, Rating.HIGH));
        eventService.create(new Event("Happy tree friends", 200, Rating.LOW));
        eventService.create(new Event("Snatch", 900, Rating.MID));

        System.out.println("\n------------------PRINT EVENT BY NAME------------------------------------");
        System.out.println(eventService.getByName("Terminator"));
        System.out.println(eventService.getByName("Chuck Norris"));
        System.out.println(eventService.getByName("Snatch"));

        System.out.println("\n------------------PRINT ALL EVENTS ------------------------------------");
        for(Event event : eventService.getAll()){
            System.out.println(event);
        }

        System.out.println("\n------------------ASSIGN EVENTS TO AUDITORIUMS ------------------------------------");
        eventService.assignAuditorium(eventService.getByName("Terminator"), auditoriumService.getAuditoriums().get(2), df.parse("01/02/2015"));
        eventService.assignAuditorium(eventService.getByName("Terminator"), auditoriumService.getAuditoriums().get(1), df.parse("01/02/2015"));
        eventService.assignAuditorium(eventService.getByName("Terminator"), auditoriumService.getAuditoriums().get(2), df.parse("02/02/2015"));
        eventService.assignAuditorium(eventService.getByName("Chuck Norris"), auditoriumService.getAuditoriums().get(1), df.parse("05/02/2016"));
        eventService.assignAuditorium(eventService.getByName("Chuck Norris"), auditoriumService.getAuditoriums().get(1), df.parse("06/02/2016"));
        eventService.assignAuditorium(eventService.getByName("Snatch"), auditoriumService.getAuditoriums().get(1), df.parse("01/05/2015"));

        System.out.println("\n------------------TEST REMOVE METHOD ------------------------------------");
        Event wrongEvent = new Event("WrongEvent", 20, Rating.LOW);
        eventService.create(wrongEvent);
        System.out.println("Wrong event: " + eventService.getByName("WrongEvent"));
        System.out.println("------------------Removing event ------------------------------------");
        eventService.remove(wrongEvent);
        System.out.println("Trying to print removed event (Expected null): " + eventService.getByName("WrongEvent"));

        System.out.println("\n------------------TEST GET BY ID METHOD ------------------------------------");
        Event testEvent = new Event("TestEvent", 10, Rating.MID);
        eventService.create(testEvent);
        int eventId = eventService.getEventId(testEvent);
        System.out.println("Test Event id(using getEventId method): " + eventId);
        System.out.println("Event by id(" + eventId + "): " + eventService.getById(eventId));

        System.out.println("\n------------------TEST GET NEXT EVENTS------------------------------------");
        System.out.println(eventService.getNextEvents(df.parse("05/02/2020")));

        System.out.println("\n\n\n------------------AUDITORIUM SERVICE TEST------------------------------------");
        for(Auditorium auditorium : auditoriumService.getAuditoriums()){
            System.out.println(auditorium);
        }


        System.out.println("\n\n\n------------------BOOKING SERVICE TEST------------------------------------");
        BookingService bookingService = appContext.getBean("bookingService", BookingService.class);

        System.out.println("\n------------------PRINT EVENTS PRICES------------------------------------");
        List<EventShow> eventShowList = eventService.getForDateRange(df.parse("01/01/2015"), df.parse("01/12/2015"));
        for (EventShow eventShow: eventShowList){
            System.out.println("VIP: " + bookingService.getTicketPrice(new Ticket(eventShow, eventShow.getAuditorium().getVipSeats().get(1)), vitali));
            System.out.println("NOVIP: " + bookingService.getTicketPrice(new Ticket(eventShow, 20), vitali));
        }
        System.out.println("\n-------------------------------------------------------------------------");
        eventShowList = eventService.getForDateRange(df.parse("01/01/2015"), df.parse("06/02/2016"));
        for (EventShow eventShow: eventShowList){
            System.out.println("VIP: " + bookingService.getTicketPrice(new Ticket(eventShow, eventShow.getAuditorium().getVipSeats().get(1)), vitali111));
            System.out.println("NOVIP: " + bookingService.getTicketPrice(new Ticket(eventShow, 20), vitali111));
        }

        System.out.println("\n------------------BOOKING TICKETS------------------------------------");
        bookingService.bookTicket(new Ticket(eventShowList.get(1), 1), vitali);
        try{
            bookingService.bookTicket(new Ticket(eventShowList.get(1), 1), vitali);
        }catch (TicketIsBookedException e){
            System.out.println("Ticket " + e.getTicket() + "is already booked");
        }
        bookingService.bookTicket(new Ticket(eventShowList.get(1), 2), vitali);
        System.out.println("\n------------------PRINT USER'S BOOKED TICKETS------------------------------------");
        for (Ticket ticket: vitali.getTickets()){
            System.out.println(ticket);
        }
        System.out.println(userService.getBookedTickets(userService.getUserId(vitali)));


        System.out.println("\n------------------PRINT ALL TICKETS FOR EVENT------------------------------------");
        for (Ticket ticket: bookingService.getTicketsForEvent(eventShowList.get(0))){
            System.out.println(ticket);
        }

        System.out.println("\n\n\n------------------DISCOUNT SERVICE TEST------------------------------------");
        System.out.println("\n------------------CHECK EVERY TEN TICKET DISCOUNT------------------------------------");
        for (int i = 0; i < 28; i++) {
            bookingService.bookTicket(new Ticket(eventShowList.get(2), i), vitali);
            System.out.println(i + " -- " + bookingService.getTicketPrice(new Ticket(eventShowList.get(2),i),vitali));
        }

        System.out.println("\n------------------CHECK BIRTHDAY DISCOUNT------------------------------------");
        eventShowList.get(2).setDate(vitali.getBirthday());
        for (int i = 29; i < 50; i++) {
            bookingService.bookTicket(new Ticket(eventShowList.get(2), i), vitali);
            System.out.println(i + " -- " + bookingService.getTicketPrice(new Ticket(eventShowList.get(2),i),vitali));
        }

        System.out.println("\n\n\n------------------AOP TESTS------------------------------------");
        System.out.println("\n------------------COUNTER ASPECT TEST------------------------------------");
        CounterService counterService = appContext.getBean("counterService", CounterService.class);
        System.out.println("getByName:  " + counterService.getCounter("getByName"));
        System.out.println("getTicketPrice: " + counterService.getCounter("getTicketPrice"));
        System.out.println("bookTicket: " + counterService.getCounter("bookTicket"));

        System.out.println("\n------------------DISCOUNT ASPECT TEST------------------------------------");
        System.out.println("Total every ten strategy:  " + counterService.getCounter("by.epam.training.service.discount.EveryTenTicketStrategy-getDiscount"));
        System.out.println("Vitali_Ihnatsenka@epam.com -- every ten strategy: " + counterService.getCounter("by.epam.training.service.discount.EveryTenTicketStrategy-getDiscount-Vitali_Ihnatsenka@epam.com"));
        System.out.println("Vitali_111@epam.com: -- every ten strategy: " + counterService.getCounter("by.epam.training.service.discount.BirthdayStrategy-getDiscount-Vitali_111@epam.com"));
        System.out.println("Total birthday strategy:  " + counterService.getCounter("by.epam.training.service.discount.BirthdayStrategy-getDiscount"));
        System.out.println("Vitali_Ihnatsenka@epam.com -- birthday strategy: " + counterService.getCounter("by.epam.training.service.discount.BirthdayStrategy-getDiscount-Vitali_Ihnatsenka@epam.com"));
        System.out.println("Vitali_111@epam.com: -- birthday strategy: " + counterService.getCounter("by.epam.training.service.discount.BirthdayStrategy-getDiscount-Vitali_111@epam.com"));

        System.out.println("\n------------------LUCKY WINNER ASPECT TEST------------------------------------");
        for(Ticket ticket: vitali.getTickets()){
            System.out.println(bookingService.getTicketPrice(ticket, vitali));
        }

        System.out.println("\n------------------JDBC TEST------------------------------------");
        JdbcTemplate jdbcTemplate = appContext.getBean("jdbcTemplate", JdbcTemplate.class);
        int testCount = jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
        System.out.println("TEST COUNT --------------------------- " + testCount);
    }

}
