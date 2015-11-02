package by.epam.training.service;

import by.epam.training.domain.Auditorium;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public interface AuditoriumService {
    List<Auditorium> getAuditoriums();
    // FIXME: 0.5% missing getSeatsNumber, getVipSeats
}
