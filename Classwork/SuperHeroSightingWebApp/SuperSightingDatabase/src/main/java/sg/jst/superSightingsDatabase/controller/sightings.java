package sg.jst.superSightingsDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sg.jst.superSightingsDatabase.DAO.*;
import sg.jst.superSightingsDatabase.DTO.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class sightings {
    @Autowired
    sightingEventDAOImp dao;
    @Autowired
    SuperHeroDAOImp shdao;

    @Autowired
    sightingLocationDAOImp SLdao;

    @GetMapping("sightings")
    public String loadPage(Model model) {
        List<SuperHeroDTO> shdtos = shdao.ReadAll();
        model.addAttribute("ASuperHeros", shdtos);
        List<sightingLocationDTO> dtos = SLdao.ReadAll();
        model.addAttribute("sLocations", dtos);
        List<sightingEventDTO> sedtos = dao.ReadAll();
        for (sightingEventDTO i : sedtos) {
            SuperHeroDTO sh = shdao.GetSuperHeroById(i.getSuperHeroId());
            i.setSuperHeroName(sh.getName());
            sightingLocationDTO loc = SLdao.GetsightingLocationId(i.getSL_ID());
            i.setLocationName(loc.getName());
        }
        model.addAttribute("sSightingEvents",sedtos);
        return "sightings";
    }

    @GetMapping("deleteSightingEvents")
    public String deleteSightings(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("SightingEventId"));
        sightingEventDTO dto = dao.GetsightingEventById(id);
        List<SuperHeroDTO> shDtos = shdao.ReadAll();
        model.addAttribute("ASuperHeros",shDtos);
        model.addAttribute("SuperHeroIdSelected",dto.getSuperHeroId());
        List<sightingLocationDTO> SLdtos = SLdao.ReadAll();
        model.addAttribute("sLocations",SLdtos);
        model.addAttribute("SL_IDSelected",dto.getSL_ID());
        model.addAttribute("SightingEventId",id);
        model.addAttribute("EventDate",dto.getEventDate());
        return "deleteSightings";
    }

    @GetMapping("/deleteSightingEvent")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("SightingEventId"));
        sightingEventDTO dto = dao.GetsightingEventById(id);
        dao.DeletesightingEvent(dto);
        return "redirect:/sightings";
    }

    @PostMapping("AddSightingEvent")
    public String addSuper(HttpServletRequest request) {
        String SuperHeroId = request.getParameter("SuperHeroId");
        sightingEventDTO dto = new sightingEventDTO();
        dto.setSuperHeroId(Integer.parseInt(SuperHeroId));
        String SightingLocationId = request.getParameter("SL_ID");
        dto.setSL_ID(Integer.parseInt(SightingLocationId));
        String timeStringa = request.getParameter("EventDate");
        if(timeStringa.isEmpty()) // Add a check for no date add in now if its blank.
        {
            timeStringa = String.valueOf(java.time.LocalDateTime.now());
        }
        dto.setEventDate(timeStringa);
        dao.CreatesightingEvent(dto);
        return "redirect:/sightings";
    }

    @GetMapping("editSightingEvent")
    public String editSightings(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("SightingEventId"));
        sightingEventDTO dto = dao.GetsightingEventById(id);
        List<SuperHeroDTO> shDtos = shdao.ReadAll();
        model.addAttribute("ASuperHeros",shDtos);
        model.addAttribute("SuperHeroIdSelected",dto.getSuperHeroId());
        List<sightingLocationDTO> SLdtos = SLdao.ReadAll();
        model.addAttribute("sLocations",SLdtos);
        model.addAttribute("SL_IDSelected",dto.getSL_ID());
        model.addAttribute("SightingEventId",id);
        model.addAttribute("EventDate",dto.getEventDate());
        return "editSightings";
    }

    @PostMapping("EditSightingEvents")
    public String EditSightingEvent(HttpServletRequest request) {
        String SuperHeroId = request.getParameter("SuperHeroId");
        int id = Integer.parseInt(request.getParameter("SightingEventId"));
        sightingEventDTO dto = dao.GetsightingEventById(id);
        dto.setSuperHeroId(Integer.parseInt(SuperHeroId));
        String SightingLocationId = request.getParameter("SL_ID");
        dto.setSL_ID(Integer.parseInt(SightingLocationId));
        String timeStringa = request.getParameter("EventDate");
        dto.setEventDate(timeStringa);
        dao.UpdatesightingEvent(dto);
        return "redirect:/sightings";
    }


} // end  class
