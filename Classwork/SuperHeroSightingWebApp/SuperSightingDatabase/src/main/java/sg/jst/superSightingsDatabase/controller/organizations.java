package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.organizationDAOImp;
import sg.jst.superSightingsDatabase.DTO.organizationDTO;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class organizations {

    @Autowired
    organizationDAOImp  dao;

    @GetMapping("organizations")
    public String loadpage(Model model) {
        List<organizationDTO> dtos = dao.ReadAll();
        model.addAttribute("sOrganizations", dtos);
        return "organizations";
    }

    @PostMapping("addOrganization")
    public String addLocation(HttpServletRequest request) {
        String Name = request.getParameter("Name");
        String Description = request.getParameter("Description");
        String Address = request.getParameter("Address");
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Zip = request.getParameter("Zip");
        String Phone = request.getParameter("Phone");
        organizationDTO dto = new organizationDTO();
        dto.setName(Name);
        dto.setDescription(Description);
        dto.setAddress(Address);
        dto.setCity(City);
        dto.setState(State);
        dto.setZip(Zip);
        dto.setPhone(Phone);
        dao.Createorganization(dto);
        return "redirect:/organizations";
    }

    @GetMapping("deleteOrganization")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("OrganizationId"));
        organizationDTO dto = dao.GetorganizationById(id);
        dao.Deleteorganization(dto);
        return "redirect:/organizations";
    }

}
