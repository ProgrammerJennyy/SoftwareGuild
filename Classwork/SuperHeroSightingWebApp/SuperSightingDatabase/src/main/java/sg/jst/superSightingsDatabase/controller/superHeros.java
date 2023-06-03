package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.SuperHeroDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class superHeros {

    @Autowired
    SuperHeroDAOImp superHeroDAOImp;
    @GetMapping("superHeros")
    public String displayTeachers(Model model) {
        List<SuperHeroDTO> dtos = superHeroDAOImp.ReadAll();
        model.addAttribute("superHeros", dtos);
        return "superHeros";
    }
    @PostMapping("addSuper")
    public String addSuper(HttpServletRequest request) {
        String superName = request.getParameter("superName");
        String superPower = request.getParameter("superPower");
        String description = request.getParameter("description");
        SuperHeroDTO newSuper = new SuperHeroDTO();
        newSuper.setName(superName);
        newSuper.setSuperPower(superPower);
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
