package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.entity.Tournament;
import am.itspace.onlinechesstournamentrest.facade.TournamentFacade;
import am.itspace.onlinechesstournamentcommon.mapper.TournamentMapper;
import am.itspace.onlinechesstournamentcommon.repository.TournamentRepository;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentcommon.service.TournamentService;
import am.itspace.onlinechesstournamentdatatransfer.request.TournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.UpdateTournamentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tournaments")
@RequiredArgsConstructor
public class TournamentEndpoint {

    private final TournamentService tournamentService;
    private final TournamentMapper tournamentMapper;
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
    @PutMapping("{id}")
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
        return ResponseEntity.ok()
                .body(tournamentMapper.toResponseList(tournamentService.findAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(tournamentMapper.toResponse(tournamentService.getById(id)));
    }

    @PreAuthorize("hasAuthority('PLAYER')")
    @PostMapping("/signUp/{id}")
    public ResponseEntity<?> participate(@PathVariable("id") int tournamentId,
                                         @AuthenticationPrincipal CurrentUser currentUser) {
        return tournamentFacade.signUpForTournament(currentUser, tournamentId);
    }
}