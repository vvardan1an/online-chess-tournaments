package am.itspace.onlinechesstournamentrest.facade.facadeImpl;

import am.itspace.onlinechesstournamentcommon.exception.OrganizerNotFoundException;
import am.itspace.onlinechesstournamentcommon.exception.PlayerNotFoundException;
import am.itspace.onlinechesstournamentcommon.exception.WorldChessChampionNotFoundException;
import am.itspace.onlinechesstournamentcommon.mapper.WorldChessChampionMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentcommon.service.WorldChessChampionService;
import am.itspace.onlinechesstournamentcommon.util.BindingResultUtil;
import am.itspace.onlinechesstournamentdatatransfer.request.updateRequest.UpdateWccRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.creationRequest.WccRequest;
import am.itspace.onlinechesstournamentrest.facade.AdminAccessOnly;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@Slf4j
@RequiredArgsConstructor
public class AdminAccessOnlyImpl implements AdminAccessOnly {

    private final PlayerService playerService;

    private final OrganizerService organizerService;

    private final WorldChessChampionService wccService;

    private final WorldChessChampionMapper wccMapper;

    @Override
    public ResponseEntity<?> deletePlayer(int id) {
        log.info("attempt to delete player by id {}", id);
        if (!playerService.existsById(id)) {
            log.error("cannot find player by id {}", id);
            throw new PlayerNotFoundException("player with id " + id + " does not exist");
        }
        playerService.deleteById(id);
        log.info("player by id {} has been deleted", id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteOrganizer(int id) {
        log.info("attempt to delete organizer by id {}...", id);
        if (!organizerService.existsById(id)) {
            log.error("cannot find organizer by id {}", id);
            throw new OrganizerNotFoundException("organizer with id " + id + " does not exist");
        }
        organizerService.deleteById(id);
        log.info("organizer by id {} has been deleted", id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> createWorldChessChampion(WccRequest wccRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.unprocessableEntity().body(BindingResultUtil.extract(bindingResult));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(wccService.save(wccMapper.toEntity(wccRequest)));
    }

    @Override
    public ResponseEntity<?> updateWorldChessChampion(int id, UpdateWccRequest updateWccRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.unprocessableEntity().body(BindingResultUtil.extract(bindingResult));
        }
        return ResponseEntity.ok().body(wccMapper.toResponse(wccService.update(updateWccRequest, id)));
    }

    @Override
    public ResponseEntity<?> deleteWorldChessChampion(int id) {
        if (!wccService.existsById(id)) {
            log.error("cannot find WorldChessChampion by id {}", id);
            throw new WorldChessChampionNotFoundException("WorldChessChampion with id " + id + " does not exist");
        }
        wccService.deleteById(id);
        return ResponseEntity.ok().body("WorldChessChampion by id " + id + " was deleted.");
    }
}
