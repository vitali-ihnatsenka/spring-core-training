package by.epam.training.service;

import by.epam.training.dao.EventDao;
import by.epam.training.dao.exception.AuditoriumBookedException;
import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;
import by.epam.training.domain.EventShow;
import by.epam.training.domain.Rating;

import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class EventServiceImpl implements EventService {
    private EventDao eventDao;

    @Override
    public void create(String name, int baseprice, Rating rating) {
        System.out.println("-------- Create event " + new Event(name, baseprice, rating));
        eventDao.create(name, baseprice, rating);
    }

    @Override
    public void remove(Event event) {
        System.out.println("-------- Remove event " + event);
        eventDao.remove(event);
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
        // TODO: +0.5% optional method implemented
        return eventDao.getForDateRange(from, to);
    }

    @Override
    public List<EventShow> getNextEvents(Date to) {
        // TODO: +0.5% optional method implemented
        return getForDateRange(new Date(), to);
    }

    /**
     *
     * @param event
     * @param auditorium
     * @param date
     * @throws AuditoriumBookedException
     */
    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        System.out.println("--------assign EVENT: " + event + " AUDITORIUM: " + auditorium + " DATE: " + date);
        eventDao.assignAuditorium(event, auditorium, date);
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
}
