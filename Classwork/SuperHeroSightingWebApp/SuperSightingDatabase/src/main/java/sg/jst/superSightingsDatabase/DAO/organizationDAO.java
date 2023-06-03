/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sg.jst.superSightingsDatabase.DAO;

import java.util.List;
import sg.jst.superSightingsDatabase.DTO.organizationDTO;

/**
 *
 * @author Jenny
 */
public interface organizationDAO {
    public organizationDTO Createorganization(organizationDTO dto);
    public List<organizationDTO> ReadAll();
    public organizationDTO GetorganizationById(int id);
    public boolean Updateorganization(organizationDTO dto);
    public boolean Deleteorganization(organizationDTO dto);        
}
