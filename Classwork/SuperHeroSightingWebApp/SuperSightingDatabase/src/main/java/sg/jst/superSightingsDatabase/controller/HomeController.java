package sg.jst.superSightingsDatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**
     *
     * @return
     */
    @GetMapping(value={"","/","index"})
    public String index() {
        return "index";
    }



    @GetMapping("sightings")
    public String sightings() {
        return "sightings";
    }

    @GetMapping("orgToSuperHero")
    public String orgToSuperHero() {
        return "orgToSuperHero";
    }



}
