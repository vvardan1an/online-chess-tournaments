package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.PlayerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface PlayerFacade {

    /**
     * @param playerRequest player creation dto request
     * @param br            binding result
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> register(PlayerRequest playerRequest, BindingResult br);
}
