package by.epam.training.dao;

import by.epam.training.domain.Auditorium;
import by.epam.training.domain.EventShow;
import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;
import org.apache.derby.iapi.sql.Row;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 */

public class UsersDaoDBImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    private EventDao eventDao;
    private AuditoriumDao auditoriumDao;

    @Override
    public void register(String email, String name, Date birthday) {
        jdbcTemplate.update("INSERT INTO users(name, email, birthday) VALUES (?, ?, ?)", name, email, birthday);
    }

    @Override
    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", new Object[]{id});
    }

    @Override
    public User getById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", new Object[]{id}, new UserRowMapper());
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", new Object[]{email}, new UserRowMapper());
    }

    @Override
    public List<User> getUsersByName(String name) {
        return jdbcTemplate.query("SELECT * FROM users WHERE name=?", new Object[]{name}, new UserRowMapper() );
    }

    @Override
    public List<Ticket> getBookedTickets(int userId) {
        return jdbcTemplate.query("SELECT * FROM tickets WHERE user_id=?", new Object[]{userId}, new TicketRowMapper());
    }

    @Override
    public void addTicket(User user, Ticket ticket) {
        EventShow eventShow = ticket.getEventShow();
        jdbcTemplate.update("INSERT INTO tickets(event_id, auditorium_name, user_id, seat_number, show_date, lucky) VALUES(?, ?, ?, ?, ?, ?)",
                eventShow.getEvent().getId(), eventShow.getAuditorium().getName(), user.getId(), ticket.getSeatNumber(), eventShow.getDate(), ticket.isLucky());
    }

    private class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            Date birthday = resultSet.getDate("birthday");
            User user = new User(id, email, name, birthday);
            return user;
        }
    }

    private class TicketRowMapper implements RowMapper<Ticket>{
        @Override
        public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
            Ticket ticket = new Ticket();
            EventShow eventShow = new EventShow();
            int eventID = resultSet.getInt("event_id");
            eventShow.setEvent(eventDao.getById(eventID));
            String auditoriumName = resultSet.getString("auditorium_name");
            for(Auditorium auditorium : auditoriumDao.getAuditoriums()){
                if(auditorium.getName().equals(auditoriumName)){
                    eventShow.setAuditorium(auditorium);
                }
            }
            ticket.setSeatNumber(resultSet.getInt("seat_number"));
            ticket.setLucky(resultSet.getBoolean("lucky"));
            eventShow.setDate(resultSet.getDate("show_date"));
            ticket.setEventShow(eventShow);
            return ticket;
        }
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public void setAuditoriumDao(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }
}
