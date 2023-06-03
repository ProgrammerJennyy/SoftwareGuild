package sg.jst.superSightingsDatabase.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sg.jst.superSightingsDatabase.DTO.superPowerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SuperPowerDAOImp implements SuperPowerDAO {


    private final JdbcTemplate jdbc;

    @Autowired
    public SuperPowerDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    @Transactional
    public superPowerDTO CreateSuperPower(superPowerDTO dto) {
        final String INSERT_SH = "INSERT INTO superpower(SuperPowerName) "
                + "VALUES(?)";
        jdbc.update(INSERT_SH,dto.getSuperPowerName());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dto.setSuperPowerId(newId);
        return dto;
    }

    @Override
    public List<superPowerDTO> ReadAll() {
        final String sql = "SELECT SuperPowerId,SuperPowerName FROM superpower;";
        return jdbc.query(sql, new SuperPowerDAOImp.ToDoMapper());
    }

    @Override
    public superPowerDTO GetSuperPowerById(int id) {
        try {
            final String GET_SH_BY_ID = "SELECT * FROM superpower WHERE SuperPowerId = ?";
            return jdbc.queryForObject(GET_SH_BY_ID, new SuperPowerDAOImp.ToDoMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void UpdateSuperPower(superPowerDTO dto) {
        final String UPDATE_SH = "UPDATE superpower SET SuperPowerName = ? "
                + " WHERE SuperPowerId = ?";
        jdbc.update(UPDATE_SH,
                dto.getSuperPowerName(),
                dto.getSuperPowerId());
    }

    @Override
    @Transactional
    public void DeleteSuperPower(superPowerDTO dto) {
        int id=dto.getSuperPowerId();
        final String DELETE_ORG_TO = "UPDATE superpower set SuperPowerId = 1 WHERE SuperPowerId = ?";
        jdbc.update(DELETE_ORG_TO, id);
        final String DELETE_SUPERHERO = "DELETE FROM superPower WHERE SuperPowerId = ?";
        jdbc.update(DELETE_SUPERHERO, id);
    }

    private static final class ToDoMapper implements RowMapper<superPowerDTO> {

        @Override
        public superPowerDTO mapRow(ResultSet rs, int index) throws SQLException {
            superPowerDTO sp = new superPowerDTO();
            sp.setSuperPowerId(rs.getInt("SuperPowerId"));
            sp.setSuperPowerName(rs.getString("SuperPowerName"));
            return sp;
        }
    }



}
