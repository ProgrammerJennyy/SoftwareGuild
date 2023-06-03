package sg.jst.superSightingsDatabase.DAO;

import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.superPowerDTO;

import java.util.List;

public interface SuperPowerDAO {
    // CRUD
    public superPowerDTO CreateSuperPower(superPowerDTO dto);
    public List<superPowerDTO> ReadAll();
    public superPowerDTO GetSuperPowerById(int id);
    public void UpdateSuperPower(superPowerDTO dto);
    public void DeleteSuperPower(superPowerDTO dto);
}
