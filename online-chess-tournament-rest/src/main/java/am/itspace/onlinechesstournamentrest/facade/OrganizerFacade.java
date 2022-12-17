package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.OrganizerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface OrganizerFacade {

    /**
     * @param organizerRequest organizer creation dto request
     * @param br               binding result
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> register(OrganizerRequest organizerRequest, BindingResult br);
}
