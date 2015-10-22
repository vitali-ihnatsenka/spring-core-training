package by.epam.training.service;

import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public interface EventService {
    void create(Event event);
    void remove(long id);
    Event getByName(String name);
    List<Event> getAll();
    List<Event> getForDateRange(Date from, Date to);
    List<Event> getNextEvents(Date to);
    void assignAuditorium(Event event, Auditorium auditorium, Date date);

}
