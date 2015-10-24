package by.epam.training.domain;

import java.util.Date;

/**
 * Created by Vitali on 24.10.2015.
 */
public class EventShow {
    private Event event;
    private Auditorium auditorium;
    private Date date;

    public EventShow(Event event, Auditorium auditorium, Date date) {
        this.event = event;
        this.auditorium = auditorium;
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
