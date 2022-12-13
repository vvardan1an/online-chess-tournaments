package am.itspace.onlinechesstournamentrest.facade.facadeImpl;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.entity.Tournament;
import am.itspace.onlinechesstournamentcommon.exception.AccessDeniedException;
import am.itspace.onlinechesstournamentcommon.exception.TournamentNotFoundException;
import am.itspace.onlinechesstournamentcommon.mapper.TournamentMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentcommon.service.TournamentService;
import am.itspace.onlinechesstournamentcommon.util.BindingResultUtil;
import am.itspace.onlinechesstournamentdatatransfer.request.TournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.UpdateTournamentRequest;
import am.itspace.onlinechesstournamentrest.facade.TournamentFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class TournamentFacadeImpl implements TournamentFacade {

    private final TournamentMapper tournamentMapper;
    private final OrganizerService organizerService;
    private final TournamentService tournamentService;
    private final PlayerService playerService;

    @Override
    public ResponseEntity<?> createTournament(TournamentRequest tournamentRequest, CurrentUser currentUser, BindingResult br) {
        if (br.hasErrors()) return ResponseEntity.badRequest().body(BindingResultUtil.check(br));
        Tournament tournament = tournamentMapper.toEntity(tournamentRequest);
        Organizer organizer = organizerService.findByEmail(currentUser.getUsername());
        tournament.setOrganizer(organizer);
        return ResponseEntity.ok().body(tournamentMapper.toResponse(tournamentService.save(tournament)));
    }

    @Override
    public ResponseEntity<?> update(UpdateTournamentRequest updateRequest, int id, CurrentUser currentUser, BindingResult br) {
        checkIfTournamentIsPresent(id);
        Tournament tournament = tournamentService.findById(id);
        Organizer organizer = organizerService.findByEmail(currentUser.getUsername());
        if (organizer.getId() == tournament.getOrganizer().getId()) {
            if (br.hasErrors()) return ResponseEntity.badRequest().body(BindingResultUtil.check(br));
            Tournament savedTournament = tournamentService.save(tournamentMapper.toEntity(updateRequest));
            return ResponseEntity.ok().body(tournamentMapper.toResponse(savedTournament));
        }
        throw new AccessDeniedException("update process failed:" +
                " current organizer does not have access to tournament by id " + id);
    }

    @Override
    public ResponseEntity<?> delete(int id, CurrentUser currentUser) {
        checkIfTournamentIsPresent(id);
        Tournament tournament = tournamentService.getById(id);
        Object[] objects = currentUser.getAuthorities().toArray();
        for (Object object : objects) {
            if (object.toString().equals("ORGANIZER")) {
                Organizer organizer = organizerService.findByEmail(currentUser.getUsername());
                if (organizer.getId() == tournament.getOrganizer().getId()) {
                    tournamentService.delete(tournament);
                    return ResponseEntity.ok().body("tournament by id " + id + " was deleted");
                }
                throw new AccessDeniedException("deleting process failed:" +
                        " current organizer does not have access to tournament by id " + id);
            } else if (object.toString().equals("ADMIN")) {
                tournamentService.delete(tournament);
                return ResponseEntity.ok().body("tournament by id " + id + " was deleted");
            }
        }
        throw new AccessDeniedException("cannot recognize current user");
    }

    @Override
    public ResponseEntity<?> signUpForTournament(CurrentUser currentUser, int tournamentId) {
        checkIfTournamentIsPresent(tournamentId);
        Tournament tournament = tournamentService.findById(tournamentId);
        List<Player> playerList = tournament.getPlayerList();
        playerList.add(playerService.findByEmail(currentUser.getUsername()));
        return ResponseEntity.ok().body(tournamentMapper.toResponse(tournamentService.save(tournament)));
    }

    private void checkIfTournamentIsPresent(int id) {
        if (!tournamentService.isPresent(id)) {
            throw new TournamentNotFoundException("cannot find tournament by id " + id);
        }
    }
}
