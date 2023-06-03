/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sg.jst.superSightingsDatabase.DAO;

import java.util.List;
import sg.jst.superSightingsDatabase.DTO.org_to_superheroDTO;

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
public class org_to_superheroDAOImp implements org_to_superheroDAO {

    private final JdbcTemplate jdbc;

    @Autowired
    public org_to_superheroDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }
  
    @Override
    @Transactional    
    public org_to_superheroDTO CreateOrgToSuperhero(org_to_superheroDTO dto) {
        final String INSERT_SH = "INSERT INTO org_to_superhero(SuperHeroId, OrganizationId) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_SH,
                dto.getSuperHeroId(),
                dto.getOrganizationId());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dto.setOrgToShID(newId);
        return dto;
    }

    @Override
    public List<org_to_superheroDTO> ReadAll() {
        final String sql = "SELECT orgToShID,SuperHeroId,OrganizationId FROM org_to_superhero;";
        return jdbc.query(sql, new ToDoMapper());    
    }

    @Override
    public org_to_superheroDTO OrgToSuperheroById(int id) {
        try {
            final String GET_SH_BY_ID = "SELECT * FROM org_to_superhero WHERE orgToShID = ?";
            return jdbc.queryForObject(GET_SH_BY_ID, new ToDoMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }    
    }

    @Override
    public boolean UpdateOrgToSuperhero(org_to_superheroDTO dto) {
        final String UPDATE_SH = "UPDATE org_to_superhero SET SuperHeroId = ?, OrganizationId = ? "
                + " WHERE orgToShID = ?";
        jdbc.update(UPDATE_SH,
                dto.getSuperHeroId(),
                dto.getOrganizationId(),
                dto.getOrgToShID());        
        return true;
    }

    @Override
    @Transactional
    public boolean DeletOrgToSuperhero(org_to_superheroDTO dto) {
        int id=dto.getOrgToShID();
        final String DELETE_ORG_TO = "DELETE FROM org_to_superhero WHERE orgToShID = ?";
        jdbc.update(DELETE_ORG_TO, id);
        return true;
    }

private static final class ToDoMapper implements RowMapper<org_to_superheroDTO> {

    @Override
    public org_to_superheroDTO mapRow(ResultSet rs, int index) throws SQLException {
        org_to_superheroDTO sh = new org_to_superheroDTO();
        sh.setOrgToShID(rs.getInt("orgToShID"));
        sh.setSuperHeroId(rs.getInt("SuperHeroId"));
        sh.setOrganizationId(rs.getInt("OrganizationId"));
        return sh;
    }
}    
}
