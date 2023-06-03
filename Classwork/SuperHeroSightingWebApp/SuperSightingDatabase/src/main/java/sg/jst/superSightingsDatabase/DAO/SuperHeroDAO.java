package sg.jst.superSightingsDatabase.DAO;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import java.util.List;

public interface SuperHeroDAO {
    // CRUD
    public SuperHeroDTO CreateSuperHero(SuperHeroDTO dto);
    public List<SuperHeroDTO> ReadAll();
    public SuperHeroDTO GetSuperHeroById(int id);
    public boolean UpdateSuperHero(SuperHeroDTO dto);
    public boolean DeleteSuperHero(SuperHeroDTO dto);
}
