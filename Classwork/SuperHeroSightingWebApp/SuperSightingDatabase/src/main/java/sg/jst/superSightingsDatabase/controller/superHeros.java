package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.SuperHeroDAOImp;
import sg.jst.superSightingsDatabase.DAO.SuperPowerDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.superPowerDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class superHeros {

    @Autowired
    SuperHeroDAOImp superHeroDAOImp;

    @Autowired
    SuperPowerDAOImp superPowerDAOImp;

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
        superHeroDAOImp.CreateSuperHero(newSuper);
        return "redirect:superHeros";
    }
    @GetMapping("deleteSuper")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("SuperHeroId"));
        SuperHeroDTO newSuper = superHeroDAOImp.GetSuperHeroById(id);
                superHeroDAOImp.DeleteSuperHero(newSuper);
        return "redirect:/superHeros";
    }
}
