package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface PlayerFacade {

    ResponseEntity<?> register(PlayerRequest playerRequest, BindingResult br);
}
