package by.epam.training.domain;

/**
 * Created by Vitali on 20.10.2015.
 */
public class Ticket {
    private EventShow eventShow;
    private int seatNumber;
    private boolean lucky = false;

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

    public boolean isLucky() {
        return lucky;
    }

    public void setLucky(boolean lucky) {
        this.lucky = lucky;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (lucky != ticket.lucky) return false;
        if (seatNumber != ticket.seatNumber) return false;
        if (eventShow != null ? !eventShow.equals(ticket.eventShow) : ticket.eventShow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventShow != null ? eventShow.hashCode() : 0;
        result = 31 * result + seatNumber;
        result = 31 * result + (lucky ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "eventShow=" + eventShow +
                ", seatNumber=" + seatNumber +
                ", lucky=" + lucky +
                '}';
    }
}
