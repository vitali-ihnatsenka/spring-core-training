package by.epam.training.service;

import by.epam.training.dao.AuditoriumDao;
import by.epam.training.domain.Auditorium;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class AuditoriumServiceImpl implements AuditoriumService {
    private AuditoriumDao auditoriumDao;

    @Override
    public List<Auditorium> getAuditoriums() {
        return auditoriumDao.getAuditoriums();
    }

    @Override
    public int getSeatsNumber(Auditorium auditorium) {
        return auditorium.getNumberOfSeats();
    }

    @Override
    public List<Integer> getVipSeats(Auditorium auditorium) {
        return auditorium.getVipSeats();
    }

    public void setAuditoriumDao(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }
}
