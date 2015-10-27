package by.epam.training.service;

import by.epam.training.dao.EventDao;
import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;
import by.epam.training.domain.EventShow;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class EventServiceImpl implements EventService {
    private EventDao eventDao;

    @Override
    public void create(Event event) {
        System.out.println("-------- Create event " + event);
        eventDao.create(event);
    }

    @Override
    public void remove(int id) {
        System.out.println("-------- Remove event " + id);
        eventDao.remove(id);
    }

    @Override
    public Event getByName(String name) {
        return eventDao.getByName(name);
    }

    @Override
    public Event getById(int id) {
        return eventDao.getById(id);
    }

    @Override
    public List<Event> getAll() {
        return eventDao.getAll();
    }

    @Override
    public List<EventShow> getForDateRange(Date from, Date to) {
        return eventDao.getForDateRange(from, to);
    }

    @Override
    public List<EventShow> getNextEvents(Date to) {
        return getForDateRange(new Date(), to);
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        System.out.println("--------assign EVENT: " + event + " AUDITORIUM: " + auditorium + " DATE: " + date);
        eventDao.assignAuditorium(event, auditorium, date);
    }

    @Override
    public int getEventId(Event event) {
        return eventDao.getEventId(event);
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
}
