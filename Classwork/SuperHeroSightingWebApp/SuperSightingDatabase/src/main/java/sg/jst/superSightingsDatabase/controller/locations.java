package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.sightingLocationDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;
import sg.jst.superSightingsDatabase.DTO.superPowerDTO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class locations {

    @Autowired
    sightingLocationDAOImp SightingLocationDAOImp;

    Set<ConstraintViolation<sightingLocationDTO>> violations = new HashSet();


    @GetMapping("locations")
    public String loadpage(Model model) {
        List<sightingLocationDTO> dtos = SightingLocationDAOImp.ReadAll();
        model.addAttribute("sLocations", dtos);
        model.addAttribute("errors", violations);
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
        if(!Latitude.isEmpty()) {
            try {
                dto.setLatitude(Double.parseDouble(Latitude));
            }
            catch(Exception e){
                // error happened
            }
        }
        if(!Longitude.isEmpty()) {
            try {
                dto.setLongitude(Double.parseDouble(Longitude));
            }
            catch(Exception e){
                // error happened
            }
        }
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        if (violations.isEmpty()) {
            SightingLocationDAOImp.CreatesightingLocation(dto);
        }
        return "redirect:/locations";
    }
    @GetMapping("deleteSL")
    public String deleteSLs(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("SL_ID"));
        sightingLocationDTO dto = SightingLocationDAOImp.GetsightingLocationId(id);
        model.addAttribute("SL_ID", id);
        model.addAttribute("Name", dto.getName());
        model.addAttribute("Description", dto.getDescription());
        model.addAttribute("Address", dto.getAddress());
        model.addAttribute("City", dto.getCity());
        model.addAttribute("Latitude", dto.getLatitude());
        model.addAttribute("Longitude", dto.getLongitude());
        model.addAttribute("State", dto.getState());
        model.addAttribute("Zip", dto.getZip());
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        model.addAttribute("errors", violations);
        return "deleteLocations";
    }

    @GetMapping("deleteLocation")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("SL_ID"));
        sightingLocationDTO dto = SightingLocationDAOImp.GetsightingLocationId(id);
        SightingLocationDAOImp.DeletesightingLocation(dto);
        return "redirect:/locations";
    }
    @GetMapping("editSL")
    public String editSLs(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("SL_ID"));
        sightingLocationDTO dto = SightingLocationDAOImp.GetsightingLocationId(id);
        model.addAttribute("SL_ID", id);
        model.addAttribute("Name", dto.getName());
        model.addAttribute("Description", dto.getDescription());
        model.addAttribute("Address", dto.getAddress());
        model.addAttribute("City", dto.getCity());
        model.addAttribute("Latitude", dto.getLatitude());
        model.addAttribute("Longitude", dto.getLongitude());
        model.addAttribute("State", dto.getState());
        model.addAttribute("Zip", dto.getZip());
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        model.addAttribute("errors", violations);
        return "editLocations";
    }

    @PostMapping("EditLocation")
    public String updateLocation(@Valid sightingLocationDTO dto, BindingResult result, HttpServletRequest request, Model model) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        if (violations.isEmpty()) {
            SightingLocationDAOImp.UpdatesightingLocation(dto);
            return "redirect:/locations";
        }
        else
        {
            model.addAttribute("SL_ID", dto.getSL_ID());
            model.addAttribute("Name", dto.getName());
            model.addAttribute("Description", dto.getDescription());
            model.addAttribute("Address", dto.getAddress());
            model.addAttribute("City", dto.getCity());
            model.addAttribute("Latitude", dto.getLatitude());
            model.addAttribute("Longitude", dto.getLongitude());
            model.addAttribute("State", dto.getState());
            model.addAttribute("Zip", dto.getZip());
            model.addAttribute("errors", violations);
            return "editLocations";
        }




    }


}
