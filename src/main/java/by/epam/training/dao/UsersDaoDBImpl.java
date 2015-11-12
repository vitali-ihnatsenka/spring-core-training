package by.epam.training.dao;

import by.epam.training.domain.Ticket;
import by.epam.training.domain.User;
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
        return jdbcTemplate.queryForObject("SELECT name, email, birthday FROM users WHERE id=?", new Object[]{id} , new UserRowMapper());
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT name, email, birthday FROM users WHERE email=?", new Object[]{email}, new UserRowMapper());
    }

    @Override
    public List<User> getUsersByName(String name) {
        return jdbcTemplate.query("SELECT name, email, birthday FROM users WHERE name=?", new Object[]{name}, new UserRowMapper() );
    }

    @Override
    public List<Ticket> getBookedTickets(int userId) {
       // return jdbcTemplate.query("SELECT * FROM users WHERE name=?", new Object[]{name}, new UserRowMapper() );
        return null;
    }

    @Override
    public int getUserId(User user) {
        return jdbcTemplate.queryForObject("SELECT id FROM users WHERE name=? AND email=? AND birthday=?",
                new Object[]{user.getName(), user.getEmail(), user.getBirthday()}, Integer.class);
    }

    @Override
    public void addTicket(User user, Ticket ticket) {

    }

    private class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            Date birthday = resultSet.getDate("birthday");
            User user = new User(email, name, birthday);

            return user;
        }
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
