package am.itspace.onlinechesstournamentrest.facade.facadeImpl;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.entity.Tournament;
import am.itspace.onlinechesstournamentcommon.exception.AccessDeniedException;
import am.itspace.onlinechesstournamentcommon.exception.TimeCreationException;
import am.itspace.onlinechesstournamentcommon.exception.TournamentNotFoundException;
import am.itspace.onlinechesstournamentcommon.mapper.TournamentMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentcommon.service.TournamentService;
import am.itspace.onlinechesstournamentcommon.util.BindingResultUtil;
import am.itspace.onlinechesstournamentdatatransfer.request.TournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.UpdateTournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.TournamentResponse;
import am.itspace.onlinechesstournamentrest.facade.TournamentFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
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
    public ResponseEntity<?> createTournament(TournamentRequest tournamentRequest,
                                              CurrentUser currentUser, BindingResult br) {
        if (br.hasErrors()) {
            return ResponseEntity.badRequest().body(BindingResultUtil.extract(br));
        }

        DateTimeValidator(tournamentRequest.getStartDate(),
                tournamentRequest.getEndDate(),
                tournamentRequest.getParticipationEntryDeadline());

        Tournament tournament = tournamentMapper.toEntity(tournamentRequest);
        tournament.setOrganizer(organizerService.findByEmail(currentUser.getUsername()));
        return ResponseEntity.ok().body(tournamentMapper.toResponse(tournamentService.save(tournament)));
    }

    @Override
    public ResponseEntity<?> update(UpdateTournamentRequest updateRequest, int id,
                                    CurrentUser currentUser, BindingResult br) {
        DateTimeValidator(updateRequest.getStartDate(),
                updateRequest.getEndDate(),
                updateRequest.getParticipationEntryDeadline());

        tournamentAvailabilityCheck(id);
        Tournament tournamentById = tournamentService.findById(id);
        Organizer organizer = tournamentById.getOrganizer();
        Organizer organizerByEmail = organizerService.findByEmail(currentUser.getUsername());

        if (organizerByEmail.getId() == organizer.getId()) {
            if (br.hasErrors()) {
                return ResponseEntity.unprocessableEntity().body(BindingResultUtil.extract(br));
            }
            Tournament tournament = tournamentMapper.toEntity(updateRequest);
            tournament.setId(id);
            tournament.setOrganizer(organizerService.findByEmail(currentUser.getUsername()));
            Tournament savedTournament = tournamentService.save(tournament);
            return ResponseEntity.ok().body(tournamentMapper.toResponse(savedTournament));
        }
        throw new AccessDeniedException("update process failed:" +
                " current organizer does not have access to tournament by id " + id);
    }

    @Override
    public ResponseEntity<?> delete(int id, CurrentUser currentUser) {
        tournamentAvailabilityCheck(id);
        Tournament tournament = tournamentService.findById(id);

        Object[] objects = currentUser.getAuthorities().toArray();
        String authority = null;
        for (Object object : objects) {
            if (object.toString().equals("ORGANIZER")) {
                authority = "ORGANIZER";
                break;
            }
            if (object.toString().equals("ADMIN")) {
                authority = "ADMIN";
                break;
            }
        }

        assert authority != null;
        if (authority.equals("ORGANIZER")) {
            Organizer organizer = organizerService.findByEmail(currentUser.getUsername());
            if (organizer.getId() == tournament.getOrganizer().getId()) {
                tournamentService.delete(tournament);
                return ResponseEntity.ok().body("tournament by id " + id + " was deleted by organizer");
            }
            throw new AccessDeniedException("deleting process failed:" +
                    " current organizer does not have access to tournament by id " + id);
        }

        tournamentService.delete(tournament);
        return ResponseEntity.ok().body("tournament by id " + id + " was deleted by admin");
    }

    @Override
    public ResponseEntity<?> signUpForTournament(CurrentUser currentUser, int tournamentId) {
        tournamentAvailabilityCheck(tournamentId);
        Tournament tournament = tournamentService.findById(tournamentId);

        Player player = playerService.findByEmail(currentUser.getUsername());
        List<Player> playerList = tournament.getPlayerList();

        log.info("checking current player presence in playerList");
        if (playerList.contains(player)) {
            log.error("participation request denied for " + currentUser.getUsername() +
                    " as current player is already signed up for this tournament");
            return ResponseEntity.badRequest().body("already signed up for this tournament");
        }

        playerList.add(player);
        tournament.setParticipantCount(tournament.getParticipantCount() + 1);
        return ResponseEntity.ok().body(tournamentMapper.toResponse(tournamentService.save(tournament)));
    }

    @Override
    public ResponseEntity<?> withdraw(int id, CurrentUser currentUser) {
        tournamentAvailabilityCheck(id);
        Tournament tournament = tournamentService.findById(id);

        Player player = playerService.findByEmail(currentUser.getUsername());
        log.info("checking current player presence in " + tournament.getName() + " tournament's list");
        if (!tournament.getPlayerList().contains(player)) {
            log.error("tournament withdrawal request denied," +
                    " as current player is not signed up for tournament: " + tournament.getName());
            return ResponseEntity.badRequest().body(currentUser.getUsername() + " is not signed up for tournament");
        }

        log.info("removing player from playerList");
        tournament.getPlayerList().remove(player);
        tournament.setParticipantCount(tournament.getParticipantCount() - 1);
        tournamentService.save(tournament);
        return ResponseEntity.ok().body(currentUser.getUsername() + " has withdrawn from " + tournament.getName());
    }

    @Override
    public ResponseEntity<?> getById(int id) {
        tournamentAvailabilityCheck(id);
        TournamentResponse response = tournamentMapper.toResponse(tournamentService.findById(id));
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @Override
    public ResponseEntity<?> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(tournamentMapper.toResponseList(tournamentService.findAll(pageable)));
    }

    private void tournamentAvailabilityCheck(int tournamentId) {
        if (!tournamentService.isPresent(tournamentId)) {
            throw new TournamentNotFoundException("tournament with id " + tournamentId + " does not exist");
        }
    }

    private void DateTimeValidator(LocalDateTime startDate, LocalDateTime endDate, LocalDateTime participationEntryDeadline) {
        log.info("validating localDateTime fields of given request...");
        if (!startDate.isAfter(LocalDateTime.now())
                || !startDate.isBefore(endDate)
                || !participationEntryDeadline.isBefore(startDate)
                || !participationEntryDeadline.isAfter(LocalDateTime.now())) {
            log.error("validation failed");
            throw new TimeCreationException("error has occurred while setting" +
                    " start/end/entryDeadLine dates for tournament creation");
        }
    }
}
