package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentdatatransfer.request.registrationRequest.OrganizerRequest;
import am.itspace.onlinechesstournamentrest.facade.OrganizerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/organizers")
@RequiredArgsConstructor
public class OrganizerEndpoint {

    private final OrganizerFacade organizerFacade;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid OrganizerRequest organizerRequest,
                                      BindingResult br) {
        return organizerFacade.register(organizerRequest, br);
    }
}
