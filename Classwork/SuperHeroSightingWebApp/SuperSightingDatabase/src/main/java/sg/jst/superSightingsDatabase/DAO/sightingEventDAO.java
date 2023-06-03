/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sg.jst.superSightingsDatabase.DAO;

import java.util.List;
import sg.jst.superSightingsDatabase.DTO.sightingEventDTO;

/**
 *
 * @author Jenny
 */
public interface sightingEventDAO {
    public sightingEventDTO CreatesightingEvent(sightingEventDTO dto);
    public List<sightingEventDTO> ReadAll();
    public sightingEventDTO GetsightingEventById(int id);
    public boolean UpdatesightingEvent(sightingEventDTO dto);
    public boolean DeletesightingEvent(sightingEventDTO dto);     
}
