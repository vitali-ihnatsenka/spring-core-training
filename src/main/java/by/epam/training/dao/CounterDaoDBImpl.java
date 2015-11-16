package by.epam.training.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Vitali on 16.11.2015.
 */
public class CounterDaoDBImpl implements CounterDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void incrementCounter(String name) {
        try {
            int counter = getCounter(name);
            jdbcTemplate.update("UPDATE counters SET counter_value = ? WHERE name = ?", counter + 1, name);
        }catch(EmptyResultDataAccessException e){
            jdbcTemplate.update("INSERT INTO counters (name, counter_value) VALUES (?, 1)", name);
        }
    }

    @Override
    public int getCounter(String name) {
        return jdbcTemplate.queryForObject("SELECT counter_value FROM counters WHERE name=?",new Object[]{name}, Integer.class);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
