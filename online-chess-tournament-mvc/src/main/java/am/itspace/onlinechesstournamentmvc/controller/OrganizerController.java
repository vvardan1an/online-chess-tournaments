package am.itspace.onlinechesstournamentmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganizerController {

    @GetMapping("/registerOrg")
    public String registerOrgPage() {
        return "registerOrg";
    }
}
