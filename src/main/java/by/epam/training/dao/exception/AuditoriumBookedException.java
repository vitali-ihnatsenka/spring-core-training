package by.epam.training.dao.exception;

import by.epam.training.domain.EventShow;

/**
 */

public class AuditoriumBookedException extends RuntimeException {
    private EventShow eventShow;

    public AuditoriumBookedException(EventShow eventShow) {
        this.eventShow = eventShow;
    }

    public EventShow getEventShow() {
        return eventShow;
    }
}
