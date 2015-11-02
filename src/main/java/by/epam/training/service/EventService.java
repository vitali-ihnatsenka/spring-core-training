package by.epam.training.service;

import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;
import by.epam.training.domain.EventShow;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public interface EventService {
    void create(Event event);
    // FIXME: 0.5%: never used
    void remove(int id);
    Event getByName(String name);
    // FIXME: 0.5%: never used
    Event getById(int id);
    List<Event> getAll();
    List<EventShow> getForDateRange(Date from, Date to);
    // FIXME: 0.5%: never used
    List<EventShow> getNextEvents(Date to);
    void assignAuditorium(Event event, Auditorium auditorium, Date date);
    int getEventId(Event event);

}
