package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.mapper.PlayerMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentrest.security.jwtAuth.JwtTokenUtil;
import am.itspace.onlinechesstournamentrest.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    private final AuthUtil authUtil;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid PlayerRequest playerRequest) {
        if (authUtil.hasEmailConflict(playerRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        playerRequest.setPassword(passwordEncoder.encode(playerRequest.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(playerMapper.toResponse(playerService.save(playerRequest)));
    }
}
