package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface OrganizerFacade {

    ResponseEntity<?> register(OrganizerRequest organizerRequest, BindingResult br);

}