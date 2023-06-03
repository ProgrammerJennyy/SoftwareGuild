/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sg.jst.superSightingsDatabase.DAO;

import java.util.List;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;

/**
 *
 * @author Jenny
 */
public interface sightingLocationDAO {
    public sightingLocationDTO CreatesightingLocation(sightingLocationDTO dto);
    public List<sightingLocationDTO> ReadAll();
    public sightingLocationDTO GetsightingLocationId(int id);
    public boolean UpdatesightingLocation(sightingLocationDTO dto);
    public boolean DeletesightingLocation(sightingLocationDTO dto);        
}
