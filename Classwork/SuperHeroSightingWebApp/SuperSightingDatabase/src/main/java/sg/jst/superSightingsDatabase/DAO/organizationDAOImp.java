/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sg.jst.superSightingsDatabase.DAO;

import java.util.List;
import sg.jst.superSightingsDatabase.DTO.organizationDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Jenny
 */
@Repository
public class organizationDAOImp implements organizationDAO {

    private final JdbcTemplate jdbc;

    @Autowired
    public organizationDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }
  
    @Override
    @Transactional    
    public organizationDTO Createorganization(organizationDTO dto) {
        final String INSERT_SH = "INSERT INTO organization"
                +"(Name,Address,City,State,Zip,Description,Phone) "
                + "VALUES(?,?,?,?,?,?,?)";
        jdbc.update(INSERT_SH,
                dto.getName(),
                dto.getAddress(),
                dto.getCity(),
                dto.getState(),
                dto.getZip(),
                dto.getDescription(),
                dto.getPhone()
        );
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dto.setOrganizationId(newId);
        return dto;
    }

    @Override
    public List<organizationDTO> ReadAll() {
        final String sql = "SELECT * FROM organization;";
        return jdbc.query(sql, new ToDoMapper());  
    }

    @Override
    public organizationDTO GetorganizationById(int id) {
        try {
            final String GET_SH_BY_ID = "SELECT * FROM organization WHERE OrganizationId = ?";
            return jdbc.queryForObject(GET_SH_BY_ID, new ToDoMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }     
    }

    @Override
    public boolean Updateorganization(organizationDTO dto) {
        final String UPDATE_SH = "UPDATE organization SET Name = ?, Address = ?, "
               + "City = ?, State=?, Zip = ?, Description = ?, Phone = ? "
                + " WHERE OrganizationId = ?";
        jdbc.update(UPDATE_SH,
                dto.getName(),
                dto.getAddress(),
                dto.getCity(),
                dto.getState(),
                dto.getZip(),
                dto.getDescription(),
                dto.getPhone(),
                dto.getOrganizationId()
        );        
        return true;    
    }

    @Override
    @Transactional
    public boolean Deleteorganization(organizationDTO dto) {
        int id=dto.getOrganizationId();
        final String DELETE_ORG_TO = "DELETE FROM organization WHERE OrganizationId = ?";
        jdbc.update(DELETE_ORG_TO, id);
        return true;    }

private static final class ToDoMapper implements RowMapper<organizationDTO> {

    @Override
    public organizationDTO mapRow(ResultSet rs, int index) throws SQLException {
        organizationDTO sh = new organizationDTO();
        sh.setOrganizationId(rs.getInt("OrganizationId"));
        sh.setName(rs.getString("Name"));
        sh.setAddress(rs.getString("Address"));
        sh.setCity(rs.getString("City"));
        sh.setState(rs.getString("State"));
        sh.setZip(rs.getString("Zip"));
        sh.setDescription(rs.getString("Description"));
        sh.setPhone(rs.getString("Phone"));
        return sh;
    }
}        
}
