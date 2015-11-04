package by.epam.training.dao.exception;

import by.epam.training.domain.EventShow;

/**
 */

public class AuditoriumIsBookedException extends RuntimeException {
    private EventShow eventShow;

    public AuditoriumIsBookedException(EventShow eventShow) {
        this.eventShow = eventShow;
    }

    public EventShow getEventShow() {
        return eventShow;
    }
}
