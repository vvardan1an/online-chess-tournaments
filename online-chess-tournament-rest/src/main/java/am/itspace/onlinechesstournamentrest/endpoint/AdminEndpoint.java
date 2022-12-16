package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerResponse;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerResponse;
import am.itspace.onlinechesstournamentrest.facade.AdminAccessOnly;
import lombok.RequiredArgsConstructor;
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

    private final AdminAccessOnly adminAccessOnly;

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deletePlayer/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        return adminAccessOnly.deletePlayer(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deleteOrganizer/{id}")
    public ResponseEntity<?> deleteOrganizerById(@PathVariable("id") int id) {
        return adminAccessOnly.deleteOrganizer(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAllOrganizers")
    public ResponseEntity<List<OrganizerResponse>> getAllOrganizers() {
        return ResponseEntity.ok(organizerService.findAll());
    }
}
