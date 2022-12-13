package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerResponse;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminEndpoint {

    private final PlayerService playerService;

    private final OrganizerService organizerService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deletePlayerById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        if (playerService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("player not found by id: " + id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deleteOrganizerById/{id}")
    public ResponseEntity<?> deleteOrganizerById(@PathVariable("id") int id) {
        if (organizerService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organizer not found by id: " + id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAllOrganizers")
    public ResponseEntity<List<OrganizerResponse>> getAllOrganizers() {
        return ResponseEntity.ok(organizerService.findAll());
    }
}