/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sg.jst.nb_superhero.DAO;

import java.util.List;
import sg.jst.nb_superhero.DTO.org_to_superheroDTO;

/**
 *
 * @author Jenny
 */
public interface org_to_superheroDAO {
    public org_to_superheroDTO CreateOrgToSuperhero(org_to_superheroDTO dto);
    public List<org_to_superheroDTO> ReadAll();
    public org_to_superheroDTO OrgToSuperheroById(int id);
    public boolean UpdateOrgToSuperhero(org_to_superheroDTO dto);
    public boolean DeletOrgToSuperhero(org_to_superheroDTO dto);    
    
}
