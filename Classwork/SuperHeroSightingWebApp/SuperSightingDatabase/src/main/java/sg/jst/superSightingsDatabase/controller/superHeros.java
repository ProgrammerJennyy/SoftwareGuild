package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.SuperHeroDAO;
import sg.jst.superSightingsDatabase.DAO.SuperHeroDAOImp;
import sg.jst.superSightingsDatabase.DAO.SuperPowerDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
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
public class superHeros {

    @Autowired
    SuperHeroDAOImp superHeroDAOImp;

    @Autowired
    SuperPowerDAOImp superPowerDAOImp;

    Set<ConstraintViolation<SuperHeroDTO>> violations = new HashSet();


    @GetMapping("superHeros")
    public String displayTeachers(Model model) {
        List<SuperHeroDTO> dtos = superHeroDAOImp.ReadAll();
        for(SuperHeroDTO dto: dtos)
        {
            superPowerDTO retval;
            retval=superPowerDAOImp.GetSuperPowerById(dto.getSuperPowerId());
            dto.setSuperPower(retval.getSuperPowerName());
        }
        model.addAttribute("superHeros", dtos);
        List<superPowerDTO> spDtos = superPowerDAOImp.ReadAll();
        model.addAttribute("superPowerId",spDtos);
        model.addAttribute("errors", violations);

        return "superHeros";
    }
    @PostMapping("addSuper")
    public String addSuper(HttpServletRequest request) {
        String superName = request.getParameter("superName");
        String superPowerId = request.getParameter("superPowerId");
        String description = request.getParameter("description");
        SuperHeroDTO newSuper = new SuperHeroDTO();
        newSuper.setName(superName);
        newSuper.setSuperPowerId(Integer.parseInt(superPowerId));
        newSuper.setDescription(description);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(newSuper);
        if (violations.isEmpty()) {
            superHeroDAOImp.CreateSuperHero(newSuper);
        }
        return "redirect:/superHeros";
    }

    @GetMapping("deleteSuper")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("SuperHeroId"));
        SuperHeroDTO newSuper = superHeroDAOImp.GetSuperHeroById(id);
                superHeroDAOImp.DeleteSuperHero(newSuper);
        return "redirect:/superHeros";
    }
    @PostMapping("EditSuper")
    public String editSuper(@Valid SuperHeroDTO dto, BindingResult result, HttpServletRequest request, Model model) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        if (violations.isEmpty()) {
            superHeroDAOImp.UpdateSuperHero(dto);
            return "redirect:/superHeros";
        }
        else {
            model.addAttribute("errors", violations);
            model.addAttribute("Name", dto.getName());
            model.addAttribute("superPowerId", dto.getSuperPowerId());
            model.addAttribute("description", dto.getDescription());
            List<superPowerDTO> spDtos = superPowerDAOImp.ReadAll();
            model.addAttribute("superPowerId",spDtos);
            model.addAttribute("SuperPowerIdSelected",dto.getSuperPowerId());
            return "editSuperHeros";
        }
    }

    @GetMapping("editSHs")
    public String editSHs(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("SuperHeroId"));
        SuperHeroDTO dto = superHeroDAOImp.GetSuperHeroById(id);
        model.addAttribute("Name", dto.getName());
        model.addAttribute("description",dto.getDescription());
        List<superPowerDTO> spDtos = superPowerDAOImp.ReadAll();
        model.addAttribute("superPowerId",spDtos);
        model.addAttribute("SuperHeroId",id);
        model.addAttribute("SuperPowerIdSelected",dto.getSuperPowerId());
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        model.addAttribute("errors", violations);

        return "editSuperHeros";
    }

    @GetMapping("deleteSHs")
    public String deleteSHs(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("SuperHeroId"));
        SuperHeroDTO dto = superHeroDAOImp.GetSuperHeroById(id);
        model.addAttribute("Name", dto.getName());
        model.addAttribute("description",dto.getDescription());
        List<superPowerDTO> spDtos = superPowerDAOImp.ReadAll();
        model.addAttribute("superPowerId",spDtos);
        model.addAttribute("SuperHeroId",id);
        model.addAttribute("SuperPowerIdSelected",dto.getSuperPowerId());
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        model.addAttribute("errors", violations);

        return "deleteSuperHeros";
    }

} // end class
