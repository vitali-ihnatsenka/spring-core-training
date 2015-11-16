package by.epam.training.dao;

import by.epam.training.domain.Auditorium;
import by.epam.training.domain.Event;
import by.epam.training.domain.EventShow;
import by.epam.training.domain.Rating;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Vitali on 16.11.2015.
 */
public class EventDaoDBImpl implements EventDao {
    private JdbcTemplate jdbcTemplate;
    private AuditoriumDao auditoriumDao;

    @Override
    public void create(String name, int baseprice, Rating rating) {
        jdbcTemplate.update("INSERT INTO events(name, baseprice,rating) VALUES (?, ?, ?)", name, baseprice, rating.toString());
    }

    @Override
    public void remove(Event event) {
        jdbcTemplate.update("DELETE FROM events WHERE id=?", new Object[]{event.getId()});
    }

    @Override
    public Event getByName(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM events WHERE name=?", new Object[]{name}, new EventRowMapper());
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Event getById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM events WHERE id=?", new Object[]{id}, new EventRowMapper());
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Event> getAll() {
        return jdbcTemplate.query("SELECT * FROM events", new EventRowMapper());
    }

    @Override
    public List<EventShow> getForDateRange(Date from, Date to) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return jdbcTemplate.query("SELECT * FROM event_show WHERE show_date BETWEEN ? AND ?",
                 new Object[]{dateFormat.format(from), dateFormat.format(to)}, new EventShowRowMapper());
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        jdbcTemplate.update("INSERT INTO event_show(event_id, auditorium_name, show_date) VALUES (?, ?, ?)", event.getId(), auditorium.getName(), date);
    }

    private class EventRowMapper implements RowMapper<Event>{
        @Override
        public Event mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int baseprice = resultSet.getInt("baseprice");
            Rating rating = Rating.valueOf(resultSet.getString("rating"));
            Event event = new Event(id, name, baseprice, rating);
            return  event;
        }
    }

    private class EventShowRowMapper implements RowMapper<EventShow>{
        @Override
        public EventShow mapRow(ResultSet resultSet, int i) throws SQLException {
            EventShow eventShow = new EventShow();
            eventShow.setId(resultSet.getInt("id"));
            eventShow.setDate(resultSet.getDate("show_date"));
            for(Auditorium auditorium : auditoriumDao.getAuditoriums()){
                if(auditorium.getName().equals(resultSet.getString("auditorium_name"))){
                    eventShow.setAuditorium(auditorium);
                    break;
                }
            }
            eventShow.setEvent(getById(resultSet.getInt("event_id")));
            return eventShow;
        }
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setAuditoriumDao(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }
}
