package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.SuperPowerDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.superPowerDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.Validation;




@Controller
public class superPowers {

    @Autowired
    SuperPowerDAOImp superPowerDAOImp;

    Set<ConstraintViolation<superPowerDTO>> violations = new HashSet();

    @GetMapping("superPowers")
    public String displayPowers(Model model) {
        List<superPowerDTO> dtos = superPowerDAOImp.ReadAll();
        model.addAttribute("superPowers", dtos);
        model.addAttribute("errors", violations);
        return "superPowers";
    }

    @PostMapping("addPower")
    public String addPower(HttpServletRequest request) {
        String superName = request.getParameter("superPowerName");
        superPowerDTO dto = new superPowerDTO();
        dto.setSuperPowerName(superName);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        if (violations.isEmpty()) {
            superPowerDAOImp.CreateSuperPower(dto);
        }
        return "redirect:/superPowers";
    }

    @GetMapping("deleteSP")
    public String deleteSPs(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("SuperPowerId"));
        superPowerDTO dto = superPowerDAOImp.GetSuperPowerById(id);
        model.addAttribute("SuperPowerName", dto.getSuperPowerName());
        model.addAttribute("SuperPowerId", dto.getSuperPowerId());
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        model.addAttribute("errors", violations);
        return "deleteSuperPowers";
     }

    @GetMapping("deletePower")
    public String deleteSuper(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("SuperPowerId"));
        superPowerDTO dto = superPowerDAOImp.GetSuperPowerById(id);
        superPowerDAOImp.DeleteSuperPower(dto);
        return "redirect:/superPowers";
    }

    @GetMapping("editSP")
    public String editSHs(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("SuperPowerId"));
        superPowerDTO dto = superPowerDAOImp.GetSuperPowerById(id);
        model.addAttribute("SuperPowerName", dto.getSuperPowerName());
        model.addAttribute("SuperPowerId", dto.getSuperPowerId());
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        model.addAttribute("errors", violations);
         return "editSuperPowers";
    }


//    @PostMapping("EditPower")
//    public String editPower(HttpServletRequest request) {
//        String superPowerName = request.getParameter("SuperPowerName");
//        String superPowerId = request.getParameter("SuperPowerId");
//        int id = Integer.parseInt(request.getParameter("SuperPowerId"));
//        superPowerDTO dto = superPowerDAOImp.GetSuperPowerById(id);
//        dto.setSuperPowerName(superPowerName);
//        superPowerDAOImp.UpdateSuperPower(dto);
//        return "redirect:/superPowers";
//    }

    @PostMapping("EditPower")
    public String performEditStudent(@Valid superPowerDTO dto, BindingResult result,HttpServletRequest request,Model model) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(dto);
        if (violations.isEmpty()) {
            superPowerDAOImp.UpdateSuperPower(dto);
            return "redirect:/superPowers";
        }
        else
        {
            model.addAttribute("errors", violations);
            model.addAttribute("SuperPowerName", dto.getSuperPowerName());
            model.addAttribute("SuperPowerId", dto.getSuperPowerId());
            return "editSuperPowers";
        }
     }

} // end class
