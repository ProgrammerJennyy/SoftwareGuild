package sg.jst.nb_superhero.DAO;
import sg.jst.nb_superhero.DTO.SuperHeroDTO;
import java.util.List;

public interface SuperHeroDAO {
    // CRUD
    public SuperHeroDTO CreateSuperHero(SuperHeroDTO dto);
    public List<SuperHeroDTO> ReadAll();
    public SuperHeroDTO GetSuperHeroById(int id);
    public boolean UpdateSuperHero(SuperHeroDTO dto);
    public boolean DeleteSuperHero(SuperHeroDTO dto);
}
