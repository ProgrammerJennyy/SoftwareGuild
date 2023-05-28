/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sg.jst.nb_superhero.DAO;

import java.util.List;
import sg.jst.nb_superhero.DTO.sightingEventDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jenny
 */
@Repository
public class sightingEventDAOImp implements sightingEventDAO {
    private final JdbcTemplate jdbc;

    @Autowired
    public sightingEventDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }
  
    @Override
    @Transactional  
    public sightingEventDTO CreatesightingEvent(sightingEventDTO dto) {
        final String INSERT_SH = "INSERT INTO sightingevent" 
                + "(SuperHeroId, SL_ID,EventDate ) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_SH,
                dto.getSuperHeroId(),
                dto.getSL_ID(),
                dto.getEventDate());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dto.setSightingEventId(newId);
        return dto;
    }

    @Override
    public List<sightingEventDTO> ReadAll() {
        final String sql = "SELECT * FROM sightingevent;";
        return jdbc.query(sql, new ToDoMapper());    
    }

    @Override
    public sightingEventDTO GetsightingEventById(int id) {
        try {
            final String GET_SH_BY_ID = "SELECT * FROM sightingevent WHERE SightingEventId = ?";
            return jdbc.queryForObject(GET_SH_BY_ID, new ToDoMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        } 
    }

    @Override
    public boolean UpdatesightingEvent(sightingEventDTO dto) {
        final String UPDATE_SH = "UPDATE sightingevent SET SuperHeroId = ?, SL_ID = ?,EventDate = ? "
                + " WHERE SightingEventId = ?";
        jdbc.update(UPDATE_SH,
                dto.getSuperHeroId(),
                dto.getSL_ID(),
                dto.getEventDate(),
                dto.getSightingEventId());
        return true;
    }

    @Override
    @Transactional
    public boolean DeletesightingEvent(sightingEventDTO dto) {
        int id=dto.getSightingEventId();
        final String DELETE_ORG_TO = "DELETE FROM sightingevent WHERE SightingEventId = ?";
        jdbc.update(DELETE_ORG_TO, id);
        return true;
    }


private static final class ToDoMapper implements RowMapper<sightingEventDTO> {

    @Override
    public sightingEventDTO mapRow(ResultSet rs, int index) throws SQLException {
        sightingEventDTO sh = new sightingEventDTO();
        sh.setSightingEventId(rs.getInt("SightingEventId"));
        sh.setSuperHeroId(rs.getInt("SuperHeroId"));
        sh.setSL_ID(rs.getInt("SL_ID"));
        sh.setEventDate(rs.getString("EventDate"));
        return sh;
    }
}        
    
}
