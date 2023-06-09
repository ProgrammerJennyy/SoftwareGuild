package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.organizationDAOImp;
import sg.jst.superSightingsDatabase.DTO.organizationDTO;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class organizations {

    @Autowired
    organizationDAOImp  dao;

    Set<ConstraintViolation<organizationDTO>> violations = new HashSet();

    @GetMapping("organizations")
    public String loadpage(Model model) {
        List<organizationDTO> dtos = dao.ReadAll();
        model.addAttribute("sOrganizations", dtos);
        model.addAttribute("errors", violations);
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
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        if (violations.isEmpty()) {
            dao.Createorganization(dto);
        }
        return "redirect:/organizations";
    }

    @GetMapping("deleteOrg")
    public String deleteSLs(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("OrganizationId"));
        organizationDTO dto = dao.GetorganizationById(id);
        model.addAttribute("OrganizationId", id);
        model.addAttribute("Name", dto.getName());
        model.addAttribute("Description", dto.getDescription());
        model.addAttribute("Address", dto.getAddress());
        model.addAttribute("City", dto.getCity());
        model.addAttribute("Phone", dto.getPhone());
        model.addAttribute("State", dto.getState());
        model.addAttribute("Zip", dto.getZip());
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        model.addAttribute("errors", violations);
        return "deleteOrganizations";
    }


    @GetMapping("deleteOrganization")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("OrganizationId"));
        organizationDTO dto = dao.GetorganizationById(id);
        dao.Deleteorganization(dto);
        return "redirect:/organizations";
    }
    @GetMapping("editOrg")
    public String editSLs(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("OrganizationId"));
        organizationDTO dto = dao.GetorganizationById(id);
        model.addAttribute("OrganizationId", id);
        model.addAttribute("Name", dto.getName());
        model.addAttribute("Description", dto.getDescription());
        model.addAttribute("Address", dto.getAddress());
        model.addAttribute("City", dto.getCity());
        model.addAttribute("Phone", dto.getPhone());
        model.addAttribute("State", dto.getState());
        model.addAttribute("Zip", dto.getZip());
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        model.addAttribute("errors", violations);
        return "editOrganizations";
    }

    @PostMapping("EditOrganization")
    public String updateOrganization(@Valid organizationDTO dto, BindingResult result, HttpServletRequest request, Model model) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        if (violations.isEmpty()) {
            dao.Updateorganization(dto);
            return "redirect:/organizations";
        } else {
            model.addAttribute("OrganizationId", dto.getOrganizationId());
            model.addAttribute("Name", dto.getName());
            model.addAttribute("Description", dto.getDescription());
            model.addAttribute("Address", dto.getAddress());
            model.addAttribute("City", dto.getCity());
            model.addAttribute("Phone", dto.getPhone());
            model.addAttribute("State", dto.getState());
            model.addAttribute("Zip", dto.getZip());
            model.addAttribute("errors", violations);
            return "editOrganizations";
        }
    }

}
