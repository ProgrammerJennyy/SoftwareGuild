package sg.jst.superSightingsDatabase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.SuperHeroDAOImp;
import sg.jst.superSightingsDatabase.DAO.org_to_superheroDAOImp;
import sg.jst.superSightingsDatabase.DAO.organizationDAOImp;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.org_to_superheroDTO;
import sg.jst.superSightingsDatabase.DTO.organizationDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class orgToSuperHero {

    @Autowired
    org_to_superheroDAOImp dao;
    @Autowired
    SuperHeroDAOImp shdao;

    @Autowired
    organizationDAOImp orgdao;

    @GetMapping("orgToSuperHero")
    public String orgToSuperHero(Model model) {
        List<org_to_superheroDTO> dtos = dao.ReadAll();
        model.addAttribute("OrgToSupers", dtos);
        for (org_to_superheroDTO i : dtos) {
            SuperHeroDTO sh = shdao.GetSuperHeroById(i.getSuperHeroId());
            i.setSuperHeroName(sh.getName());
            organizationDTO org = orgdao.GetorganizationById(i.getOrganizationId());
            i.setOrganizationName(org.getName());
        }
        List<SuperHeroDTO> shdtos = shdao.ReadAll();
        model.addAttribute("ASuperHeros", shdtos);
        List<organizationDTO> orgsdtos = orgdao.ReadAll();
        model.addAttribute("AOrganizations", orgsdtos);

        return "orgToSuperHero";
    }

    @GetMapping("/deleteOrgToSup")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("orgToShID"));
        org_to_superheroDTO dto = dao.OrgToSuperheroById(id);
        dao.DeletOrgToSuperhero(dto);
        return "redirect:/orgToSuperHero";
    }

    @PostMapping("addOrgToSuper")
    public String addSuper(HttpServletRequest request) {
        String SuperHeroId = request.getParameter("SuperHeroId");
        org_to_superheroDTO dto = new org_to_superheroDTO();
        dto.setSuperHeroId(Integer.parseInt(SuperHeroId));
        String OrganizationId = request.getParameter("OrganizationId");
        dto.setOrganizationId(Integer.parseInt(OrganizationId));
        dao.CreateOrgToSuperhero(dto);
        return "redirect:/orgToSuperHero";
    }


} // end of class

