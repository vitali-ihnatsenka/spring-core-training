package by.epam.training.service;

import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;
import by.epam.training.domain.EventShow;
import by.epam.training.domain.Rating;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public interface EventService {
    void create(String name, int baseprice, Rating rating);
    void remove(Event event);
    Event getByName(String name);
    Event getById(int id);
    List<Event> getAll();
    List<EventShow> getForDateRange(Date from, Date to);
    List<EventShow> getNextEvents(Date to);
    void assignAuditorium(Event event, Auditorium auditorium, Date date);
}
