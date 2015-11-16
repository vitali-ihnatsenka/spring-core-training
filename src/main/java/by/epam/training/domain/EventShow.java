package by.epam.training.domain;

import java.util.Date;

/**
 * Created by Vitali on 24.10.2015.
 */
public class EventShow {
    private int id;
    private Event event;
    private Auditorium auditorium;
    private Date date;

    public EventShow() {
    }

    public EventShow(Event event, Auditorium auditorium, Date date) {
        this.event = event;
        this.auditorium = auditorium;
        this.date = date;
    }

    public EventShow(int id, Event event, Auditorium auditorium, Date date) {
        this.id = id;
        this.event = event;
        this.auditorium = auditorium;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventShow eventShow = (EventShow) o;

        if (auditorium != null ? !auditorium.equals(eventShow.auditorium) : eventShow.auditorium != null) return false;
        if (date != null ? !date.equals(eventShow.date) : eventShow.date != null) return false;
        if (event != null ? !event.equals(eventShow.event) : eventShow.event != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = event != null ? event.hashCode() : 0;
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventShow{" +
                "event=" + event +
                ", auditorium=" + auditorium +
                ", date=" + date +
                '}';
    }
}
