/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sg.jst.superSightingsDatabase.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jenny
 */
@Repository
public class sightingLocationDAOImp implements sightingLocationDAO {

    private final JdbcTemplate jdbc;

    @Autowired
    public sightingLocationDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }
    
    @Override
    @Transactional
    public sightingLocationDTO CreatesightingLocation(sightingLocationDTO dto) {
        final String INSERT_SH = "INSERT INTO sightinglocation" +
        "(Name, Description , Address , City , State ,Zip, Latitude , Longitude) "
                + "VALUES(?,?,?,?, ?,?,?,?)";
        jdbc.update(INSERT_SH,
                dto.getName(),
                dto.getDescription(),
                dto.getAddress(),
                dto.getCity(),
                dto.getState(),
                dto.getZip(),
                dto.getLatitude(),
                dto.getLongitude()
        );
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dto.setSL_ID(newId);
        return dto;
    }

    @Override
    public List<sightingLocationDTO> ReadAll() {
        final String sql = "SELECT * FROM sightinglocation;";
        return jdbc.query(sql, new ToDoMapper());    
    }

    @Override
    public sightingLocationDTO GetsightingLocationId(int id) {
        try {
            final String GET_SH_BY_ID = "SELECT * FROM sightinglocation WHERE SL_ID = ?";
            return jdbc.queryForObject(GET_SH_BY_ID, new ToDoMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }    
    }

    @Override
    public boolean UpdatesightingLocation(sightingLocationDTO dto) {
        final String UPDATE_SH = "UPDATE sightinglocation SET " + 
                "Name = ?, Description = ?, Address = ?, City = ?, State = ?, "
                + " Zip = ?, Latitude = ?, Longitude = ?"
                + " WHERE SL_ID = ?";
        jdbc.update(UPDATE_SH,
                dto.getName(),
                dto.getDescription(),
                dto.getAddress(),
                dto.getCity(),
                dto.getState(),
                dto.getZip(),
                dto.getLatitude(),
                dto.getLongitude(),
                  dto.getSL_ID()
        );        
        return true;
    }

    @Override
    @Transactional
    public boolean DeletesightingLocation(sightingLocationDTO dto) {
        int id=dto.getSL_ID();
        final String DELETE_SE = "DELETE FROM sightingevent WHERE SL_ID = ?";
        jdbc.update(DELETE_SE, id);        
        final String DELETE_ORG_TO = "DELETE FROM sightinglocation WHERE SL_ID = ?";
        jdbc.update(DELETE_ORG_TO, id);
        return true;
    }


private static final class ToDoMapper implements RowMapper<sightingLocationDTO> {

    @Override
    public sightingLocationDTO mapRow(ResultSet rs, int index) throws SQLException {
        sightingLocationDTO sh = new sightingLocationDTO();
        sh.setSL_ID(rs.getInt("SL_ID"));
        sh.setName(rs.getString("Name"));
        sh.setDescription(rs.getString("Description"));
        sh.setAddress(rs.getString("Address"));
        sh.setCity(rs.getString("City"));
        sh.setState(rs.getString("State"));
        sh.setZip(rs.getString("Zip"));
        sh.setLatitude(rs.getDouble("Latitude"));
        sh.setLongitude(rs.getDouble("Longitude"));
        return sh;
    }
}
    
}
