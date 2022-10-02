package am.itspace.onlinechesstournaments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrganizerController {

    @GetMapping("/registerOrg")
    public String registerOrgPage() {
        return "registerOrg";
    }
}
