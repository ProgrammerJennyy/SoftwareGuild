package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.sightingLocationDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class locations {

    @Autowired
    sightingLocationDAOImp SightingLocationDAOImp;

    @GetMapping("locations")
    public String loadpage(Model model) {
        List<sightingLocationDTO> dtos = SightingLocationDAOImp.ReadAll();
        model.addAttribute("sLocations", dtos);
        return "locations";
    }
    @PostMapping("addLocation")
    public String addLocation(HttpServletRequest request) {
        String Name = request.getParameter("Name");
        String Description = request.getParameter("Description");
        String Address = request.getParameter("Address");
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Zip = request.getParameter("Zip");
        String Longitude = request.getParameter("Longitude");
        String Latitude = request.getParameter("Latitude");
        sightingLocationDTO dto = new sightingLocationDTO();
        dto.setName(Name);
        dto.setDescription(Description);
        dto.setAddress(Address);
        dto.setCity(City);
        dto.setState(State);
        dto.setZip(Zip);
        dto.setLatitude(Double.parseDouble(Latitude));
        dto.setLongitude(Double.parseDouble(Longitude));
        SightingLocationDAOImp.CreatesightingLocation(dto);
        return "redirect:/locations";
    }

    @GetMapping("deleteLocation")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("SL_ID"));
        sightingLocationDTO dto = SightingLocationDAOImp.GetsightingLocationId(id);
        SightingLocationDAOImp.DeletesightingLocation(dto);
        return "redirect:/locations";
    }

}