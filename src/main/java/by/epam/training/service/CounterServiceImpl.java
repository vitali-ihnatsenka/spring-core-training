package by.epam.training.service;

import by.epam.training.dao.CounterDao;

/**
 */

public class CounterServiceImpl implements CounterService {
    private CounterDao counterDao;

    @Override
    public int getCounter(String name) {
        return counterDao.getCounter(name);
    }

    public void setCounterDao(CounterDao counterDao) {
        this.counterDao = counterDao;
    }
}
