# Spring Core course:

## Task1 description:
- Create Spring application with the following services and logic using either XML or Annotation configuration.
- Create domain objects as needed.
- Create DAO classes for storing data in maps (later, they will be replaced for storing data in DB).

### UserService - Manages registered users
* register, remove, getById, getUserByEmail, getUsersByName, getBookedTickets

### EventService - Manages events (movie shows)
* create - should create Event with name, air dates and times, base price for tickets, rating (high, mid, low)
* remove, getByName, getAll
* getForDateRange(from, to) - returns events for specified date range (OPTIONAL)
* getNextEvents(to) - returns events from now till the ‘to’ date (OPTIONAL)
* assignAuditorium(event, auditorium, date) - assign auditorium for event for specific date

### AuditoriumService - Returns info about auditoriums and places
* Since auditorium information is usually static, store it in some property file. The information that needs to be stored is:
    * name
    * number of seats
    * vip seats (comma-separated list of expensive seats)

Several auditoriums can be stored in separate property files, information from them could be injected into the AuditoriumService

* getAuditoriums(), getSeatsNumber(), getVipSeats()

### BookingService - Manages tickets, prices, bookings
* getTicketPrice(event, date, time, seats, user) - returns price for ticket for specified event on specific date and time for specified seats.
* bookTicket(user, ticket) - user could  be registered or not. If user is registered, then booking information is stored for that user. Purchased tickets for particular event should be stored
* getTicketsForEvent(event, date) - get all purchased tickets for event for specific date

### DiscountService - Counts different discounts for purchased tickets
* getDiscount(user, event, date) - returns discount for each ticket for the user on particular event
* DiscountStrategy - single class with logic for calculating discount
    * Birthday strategy - give 5% if user has birthday
    * Every 10th ticket - give 50% for every 10th ticket purchased by user
* All discount strategies should be injected as list into the DiscountService. The getDiscount method will execute each strategy to get max available discount.
* Define DiscountService with all strategies as separate beans in separate configuration file (either separate XML or separate Java config class)

## Task2 description:
- CounterAspect - count how many times each event was accessed by name, how many times its prices were queried, how many times its tickets were booked. Store counters in map for now (later could be replaced by DB dao)
- DiscountAspect - count how many times each discount was given total and for specific user
- LuckyWinnerAspect - every time the bookTicket method is executed perform the checkLucky method for the user that based on some randomness will return true or false. If user is lucky, the ticketPrice changes to zero and ticket is booked, thus user pays nothing. Store the information about this lucky event into the user object (like some system messages or so) - OPTIONAL

## Task3 description:
- Create DAO objects that use JDBCTemplate to store and retrieve data from DB.
- Add DAO object to store all counters into the database.



