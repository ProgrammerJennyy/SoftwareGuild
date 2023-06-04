package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.SuperPowerDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.superPowerDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class superPowers {

    @Autowired
    SuperPowerDAOImp superPowerDAOImp;

    @GetMapping("superPowers")
    public String displayPowers(Model model) {
        List<superPowerDTO> dtos = superPowerDAOImp.ReadAll();
        model.addAttribute("superPowers", dtos);
        return "superPowers";
    }

    @PostMapping("addPower")
    public String addPower(HttpServletRequest request) {
        String superName = request.getParameter("superPowerName");
        superPowerDTO dto = new superPowerDTO();
        dto.setSuperPowerName(superName);
        superPowerDAOImp.CreateSuperPower(dto);
        return "redirect:/superPowers";
    }

    @GetMapping("deletePower")
    public String deleteSuper(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("SuperPowerId"));
        superPowerDTO dto = superPowerDAOImp.GetSuperPowerById(id);
        superPowerDAOImp.DeleteSuperPower(dto);
        return "redirect:/superPowers";
    }

    @GetMapping("editSPs")
    public String editSHs(HttpServletRequest request, Model model) {
        return "";
    }

    @PostMapping("EditPower")
    public String editPower(HttpServletRequest request) {
        return "";
    }

}
