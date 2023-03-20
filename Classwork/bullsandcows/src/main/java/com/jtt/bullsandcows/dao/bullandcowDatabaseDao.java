package com.jtt.bullsandcows.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jtt.bullsandcows.dto.bullandcowTurn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class bullandcowDatabaseDao implements bullandcowDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public bullandcowDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public bullandcowTurn add(bullandcowTurn todo) {

        final String sql = "INSERT INTO bullandcow(gameId,roundTime,secret,guess,finished) VALUES(?,?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, todo.getGameId());
            statement.setString(2, todo.getRoundTime());
            statement.setString(3, todo.getSecret());
            statement.setString(4, todo.getGuess());
            statement.setBoolean(5, todo.isFinished());

            return statement;

        }, keyHolder);

        // todo.setGameId(keyHolder.getKey().intValue());

        return todo;
    }


    @Override
    public int maxGameId() {
        final String sql = "SELECT MAX(gameId) FROM bullandcow;";
        int number=0;
        try {
            number=jdbcTemplate.queryForObject(sql, Integer.class);
        }catch(Exception x)
        {

        }
        return number;
    }
    @Override
    public List<bullandcowTurn> getAll() {
        final String sql = "SELECT gameId,roundTime,secret,guess, finished FROM bullandcow;";
        return jdbcTemplate.query(sql, new ToDoMapper());
    }

    @Override
    public List<bullandcowTurn> findById(int id) {

        final String sql = "SELECT gameId,roundTime,secret,guess,finished "
                + "FROM bullandcow WHERE gameId = "+ id;

        // return jdbcTemplate.queryForObject(sql, new ToDoMapper(), id);
        return jdbcTemplate.query(sql, new ToDoMapper());
    }

    @Override
    public boolean update(bullandcowTurn todo) {

        final String sql = "UPDATE todo SET "
                + "roundTime = ?, "
                + "guess = ?, "
                + "finished = ? "
                + "WHERE gameId = ?;";

        return jdbcTemplate.update(sql,
                todo.getRoundTime(),
                todo.getGuess(),
                todo.isFinished(),
                todo.getGameId()) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        final String sql = "DELETE FROM bullandcow WHERE gameId = ?;";
        return jdbcTemplate.update(sql, id) > 0;
    }

    private static final class ToDoMapper implements RowMapper<bullandcowTurn> {

        @Override
        public bullandcowTurn mapRow(ResultSet rs, int index) throws SQLException {
            bullandcowTurn td = new bullandcowTurn();
            td.setGameId(rs.getInt("gameId"));
            td.setRoundTime(rs.getString("roundTime"));
            td.setSecret(rs.getString("secret"));
            td.setGuess(rs.getString("guess"));
            td.setFinished(rs.getBoolean("finished"));
            return td;
        }
    }
}