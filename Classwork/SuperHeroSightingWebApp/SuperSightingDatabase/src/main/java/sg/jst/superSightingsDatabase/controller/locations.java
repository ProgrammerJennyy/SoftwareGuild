package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.sightingLocationDAOImp;
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
//    @PostMapping("addLocation")
//    public String addLocation(HttpServletRequest request) {
////        String superName = request.getParameter("superPowerName");
////        superPowerDTO dto = new superPowerDTO();
////        dto.setSuperPowerName(superName);
////        superPowerDAOImp.CreateSuperPower(dto);
//        return "redirect:/locations";
//    }


}
