package am.itspace.onlinechesstournaments.controller;

import am.itspace.onlinechesstournaments.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    public final PlayerService playerService;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

}
