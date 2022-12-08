package am.itspace.onlinechesstournamentmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
}
