package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.mapper.PlayerMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerAuthRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerAuthResponse;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerResponse;
import am.itspace.onlinechesstournamentrest.security.jwtAuth.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminEndpoint {

    private final JwtTokenUtil jwtTokenUtil;

    private final PlayerService playerService;

    private final OrganizerService organizerService;

    private final PlayerMapper playerMapper;

    private final PasswordEncoder passwordEncoder;

    @DeleteMapping("/deletePlayerById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        if (playerService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("player not found by id: " + id);
    }

    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        return ResponseEntity.ok(playerService.findAll());
    }
}
