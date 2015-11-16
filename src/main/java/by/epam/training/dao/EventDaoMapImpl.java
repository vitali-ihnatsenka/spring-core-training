package by.epam.training.dao;

import by.epam.training.dao.exception.AuditoriumBookedException;
import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;
import by.epam.training.domain.EventShow;
import by.epam.training.domain.Rating;
import by.epam.training.service.DataMapService;

import java.util.*;

/**
 * Created by Vitali on 24.10.2015.
 */
public class EventDaoMapImpl implements EventDao {
    private static Map<Integer, Event> eventMap = new HashMap<Integer, Event>();
    private static Map<Integer, EventShow> eventShowMap = new HashMap<Integer, EventShow>();
    private DataMapService dataMapService;

    @Override
    public void create(String name, int baseprice, Rating rating) {
        dataMapService.register(eventMap, new Event(name, baseprice, rating));
    }

    @Override
    public void remove(Event event) {
        eventMap.values().remove(event);
    }

    @Override
    public Event getById(int id) {
        Event event = eventMap.get(id);
        event.setId(id);
        return event;
    }

    @Override
    public Event getByName(String name) {
        for(Event event : eventMap.values()){
            if(event.getName().equals(name)){
                return event;
            }
        }
        return null;
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList<Event>(eventMap.values());
    }

    @Override
    public List<EventShow> getForDateRange(Date from, Date to) {
        List<EventShow> rangeList = new ArrayList<EventShow>();
        for(EventShow eventShow :  eventShowMap.values()){
            Date eventDate = eventShow.getDate();
            if(eventDate.before(to) && eventDate.after(from)){
                rangeList.add(eventShow);
            }
        }
        return rangeList;
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        EventShow eventShow =  new EventShow(event, auditorium, date);
        if(eventShowMap.containsValue(eventShow)){
            throw new AuditoriumBookedException(eventShow);
        }
        eventShowMap.put(dataMapService.getUniqueRandomId(eventMap.keySet()), eventShow);
    }

    public void setDataMapService(DataMapService dataMapService) {
        this.dataMapService = dataMapService;
    }
}
