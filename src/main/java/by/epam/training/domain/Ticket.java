package by.epam.training.domain;

/**
 * Created by Vitali on 20.10.2015.
 */
public class Ticket {
    private EventShow eventShow;
    private int seatNumber;

    public Ticket(EventShow eventShow, int seatNumber) {
        this.eventShow = eventShow;
        this.seatNumber = seatNumber;
    }

    public EventShow getEventShow() {
        return eventShow;
    }

    public void setEventShow(EventShow eventShow) {
        this.eventShow = eventShow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
