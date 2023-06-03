package sg.jst.superSightingsDatabase.DAO;

import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SuperHeroDAOImp implements SuperHeroDAO {

    private final JdbcTemplate jdbc;

    @Autowired
    public SuperHeroDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    @Transactional
    public SuperHeroDTO CreateSuperHero(SuperHeroDTO dto) {
        final String INSERT_SH = "INSERT INTO superhero(Name, SuperPowerId, Description) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_SH,
                dto.getName(),
                dto.getSuperPowerId(),
                dto.getDescription());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dto.setSuperHeroId(newId);
        return dto;
    }
    @Override
    public List<SuperHeroDTO> ReadAll()
    {
        final String sql = "SELECT SuperHeroId,Name,SuperPowerId,Description FROM superhero;";
        return jdbc.query(sql, new ToDoMapper());
    }
    @Override
    public boolean UpdateSuperHero(SuperHeroDTO dto)
    {
        final String UPDATE_SH = "UPDATE superhero SET Name = ?, SuperPowerId = ?, "
                + "Description = ? WHERE SuperHeroId = ?";
        jdbc.update(UPDATE_SH,
                dto.getName(),
                dto.getSuperPowerId(),
                dto.getDescription(),
                dto.getSuperHeroId());        
        return true;
    }
    
    @Override
    @Transactional
    public boolean DeleteSuperHero(SuperHeroDTO dto) {
        int id=dto.getSuperHeroId();
        final String DELETE_ORG_TO = "DELETE FROM org_to_superhero WHERE SuperHeroId = ?";
        jdbc.update(DELETE_ORG_TO, id);
        final String DELETE_SE = "DELETE FROM sightingevent WHERE SuperHeroId = ?";
        jdbc.update(DELETE_SE, id);
        final String DELETE_SUPERHERO = "DELETE FROM superhero WHERE SuperHeroId = ?";
        jdbc.update(DELETE_SUPERHERO, id);
        return true;
    }
    @Override
    public SuperHeroDTO GetSuperHeroById(int id) {
        try {
            final String GET_SH_BY_ID = "SELECT * FROM superhero WHERE SuperHeroId = ?";
            return jdbc.queryForObject(GET_SH_BY_ID, new ToDoMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

private static final class ToDoMapper implements RowMapper<SuperHeroDTO> {

    @Override
    public SuperHeroDTO mapRow(ResultSet rs, int index) throws SQLException {
        SuperHeroDTO sh = new SuperHeroDTO();
        sh.setSuperHeroId(rs.getInt("SuperHeroId"));
        sh.setName(rs.getString("Name"));
        sh.setSuperPowerId(rs.getInt("SuperPowerId"));
        sh.setDescription(rs.getString("Description"));
        return sh;
    }
}
} // end of the class.
