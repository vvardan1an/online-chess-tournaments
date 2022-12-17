package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentdatatransfer.request.creationRequest.TournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.updateRequest.UpdateTournamentRequest;
import am.itspace.onlinechesstournamentrest.facade.TournamentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tournaments")
@RequiredArgsConstructor
public class TournamentEndpoint {

    private final TournamentFacade tournamentFacade;

    @PreAuthorize("hasAuthority('ORGANIZER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody
                                    @Valid TournamentRequest tournamentRequest,
                                    @AuthenticationPrincipal CurrentUser currentUser,
                                    BindingResult br) {
        return tournamentFacade.createTournament(tournamentRequest, currentUser, br);
    }

    @PreAuthorize("hasAuthority('ORGANIZER')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody
                                    @Valid UpdateTournamentRequest updateRequest,
                                    @PathVariable("id") int id,
                                    @AuthenticationPrincipal CurrentUser currentUser,
                                    BindingResult br) {
        return tournamentFacade.update(updateRequest, id, currentUser, br);
    }

    @PreAuthorize("hasAnyAuthority('ORGANIZER', 'ADMIN')")
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") int id,
                             @AuthenticationPrincipal CurrentUser currentUser) {
        return tournamentFacade.delete(id, currentUser);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault(sort = "startDate",
            direction = Sort.Direction.DESC) Pageable pageable) {
        return tournamentFacade.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        return tournamentFacade.getById(id);
    }

    @PreAuthorize("hasAuthority('PLAYER')")
    @PostMapping("/signUp/{id}")
    public ResponseEntity<?> participate(@PathVariable("id") int tournamentId,
                                         @AuthenticationPrincipal CurrentUser currentUser) {
        return tournamentFacade.signUpForTournament(currentUser, tournamentId);
    }

    @PreAuthorize("hasAuthority('PLAYER')")
    @PostMapping("/withdraw/{id}")
    public ResponseEntity<?> withdraw(@PathVariable("id") int id,
                                      @AuthenticationPrincipal CurrentUser currentUser) {
        return tournamentFacade.withdraw(id, currentUser);
    }
}
