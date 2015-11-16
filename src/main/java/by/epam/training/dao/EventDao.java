package by.epam.training.dao;

import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;
import by.epam.training.domain.EventShow;
import by.epam.training.domain.Rating;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 24.10.2015.
 */
public interface EventDao {
    void create(String name, int baseprice, Rating rating);
    void remove(Event event);
    Event getByName(String name);
    Event getById(int id);
    List<Event> getAll();
    List<EventShow> getForDateRange(Date from, Date to);
    void assignAuditorium(Event event, Auditorium auditorium, Date date);
}
