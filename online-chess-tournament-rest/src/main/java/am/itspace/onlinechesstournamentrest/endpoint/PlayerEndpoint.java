package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.PlayerRequest;
import am.itspace.onlinechesstournamentrest.facade.PlayerFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerEndpoint {

    private final PlayerFacade playerFacade;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid PlayerRequest playerRequest,
                                      BindingResult br) {
        return playerFacade.register(playerRequest, br);
    }
}