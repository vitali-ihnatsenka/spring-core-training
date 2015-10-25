package by.epam.training.service;

import by.epam.training.domain.Auditorium;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class AuditoriumServiceImpl implements AuditoriumService {
    private List<Auditorium> auditoriums;

    @Override
    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }
}
