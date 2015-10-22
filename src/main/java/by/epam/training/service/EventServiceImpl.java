package by.epam.training.service;

import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class EventServiceImpl implements EventService {

    @Override
    public void create(Event event) {

    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Event getByName(String name) {
        return null;
    }

    @Override
    public List<Event> getAll() {
        return null;
    }

    @Override
    public List<Event> getForDateRange(Date from, Date to) {
        return null;
    }

    @Override
    public List<Event> getNextEvents(Date to) {
        return null;
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {

    }
}
