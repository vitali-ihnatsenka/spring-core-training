package by.epam.training.dao;

import by.epam.training.domain.Auditorium;

import java.util.List;

/**
 * Created by Vitali on 25.10.2015.
 */
public class AuditoriumDaoPropertiesImpl implements AuditoriumDao{
    private List<Auditorium> auditoriums;

    @Override
    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }
}
