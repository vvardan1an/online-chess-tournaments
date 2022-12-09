package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.mapper.OrganizerMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
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

@RestController
@RequestMapping("/organizers")
@RequiredArgsConstructor
public class OrganizerEndpoint {

    private final JwtTokenUtil jwtTokenUtil;

    private final OrganizerService organizerService;

    private final PlayerService playerService;

    private final OrganizerMapper organizerMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthUtil authUtil;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody OrganizerRequest organizerRequest) {
        if (authUtil.hasEmailConflict(organizerRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        organizerRequest.setPassword(passwordEncoder.encode(organizerRequest.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(organizerMapper.toResponse(organizerService.save(organizerRequest)));
    }
}
