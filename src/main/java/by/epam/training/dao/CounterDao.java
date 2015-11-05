package by.epam.training.dao;

/**
 */

public interface CounterDao {
    void incrementCounter(String name);
    int getCounter(String name);
}
