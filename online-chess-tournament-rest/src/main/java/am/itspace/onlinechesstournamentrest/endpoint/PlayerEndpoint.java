package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.mapper.PlayerMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerAuthRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerAuthResponse;
import am.itspace.onlinechesstournamentrest.security.jwtAuth.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerEndpoint {

    private final JwtTokenUtil jwtTokenUtil;

    private final PlayerService playerService;

    private final OrganizerService organizerService;

    private final PlayerMapper playerMapper;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid PlayerRequest playerRequest) {
        if (playerService.findByEmail(playerRequest.getEmail()) != null || organizerService.findByEmail(playerRequest.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        playerRequest.setPassword(passwordEncoder.encode(playerRequest.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(playerMapper.toResponse(playerService.save(playerRequest)));
    }

    @PostMapping("/auth")
    public ResponseEntity<PlayerAuthResponse> auth(@RequestBody PlayerAuthRequest playerAuthRequest) {
        Player player;

        if ((player = playerService.findByEmail(playerAuthRequest.getEmail())) == null ||
                !passwordEncoder.matches(playerAuthRequest.getPassword(), player.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(PlayerAuthResponse.builder()
                .token(jwtTokenUtil.generateToken(playerAuthRequest.getEmail()))
                .user(playerMapper.toResponse(playerService.findByEmail(playerAuthRequest.getEmail()))).build());
    }
}
