package by.epam.training.dao;

import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;
import by.epam.training.domain.EventShow;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 24.10.2015.
 */
public interface EventDao {
    void create(Event event);
    void remove(int id);
    Event getByName(String name);
    Event getById(int id);
    List<Event> getAll();
    List<EventShow> getForDateRange(Date from, Date to);
    void assignAuditorium(int eventId, Auditorium auditorium, Date date);
    int getEventId(Event event);
}
