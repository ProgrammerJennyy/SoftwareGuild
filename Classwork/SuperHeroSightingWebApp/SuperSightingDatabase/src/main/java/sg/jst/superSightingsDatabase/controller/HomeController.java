package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sg.jst.superSightingsDatabase.DAO.SuperHeroDAOImp;
import sg.jst.superSightingsDatabase.DAO.sightingEventDAOImp;
import sg.jst.superSightingsDatabase.DAO.sightingLocationDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.sightingEventDTO;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    sightingEventDAOImp dao;
    @Autowired
    SuperHeroDAOImp shdao;

    @Autowired
    sightingLocationDAOImp SLdao;

    @GetMapping(value={"","/","index"})
    public String index(Model model) {
        List<sightingEventDTO> sedtos = dao.ReadNews();
        for (sightingEventDTO i : sedtos) {
            SuperHeroDTO sh = shdao.GetSuperHeroById(i.getSuperHeroId());
            i.setSuperHeroName(sh.getName());
            sightingLocationDTO loc = SLdao.GetsightingLocationId(i.getSL_ID());
            i.setLocationName(loc.getName());
        }
        model.addAttribute("sSightingEvents", sedtos);
        return "index";
    }

}
