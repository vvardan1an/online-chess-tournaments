package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.mapper.OrganizerMapper;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerAuthRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerAuthResponse;
import am.itspace.onlinechesstournamentrest.security.jwtAuth.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody OrganizerRequest organizerRequest) {
        if (organizerService.findByEmail(organizerRequest.getEmail()) != null || playerService.findByEmail(organizerRequest.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        organizerRequest.setPassword(passwordEncoder.encode(organizerRequest.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(organizerMapper.toResponse(organizerService.save(organizerRequest)));
    }

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody OrganizerAuthRequest organizerAuthRequest) {
        Organizer organizer;

        if ((organizer = organizerService.findByEmail(organizerAuthRequest.getEmail())) == null ||
                !passwordEncoder.matches(organizerAuthRequest.getPassword(), organizer.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(OrganizerAuthResponse.builder()
                .token(jwtTokenUtil.generateToken(organizerAuthRequest.getEmail()))
                .organizer(organizerMapper.toResponse(organizerService.findByEmail(organizerAuthRequest.getEmail()))).build());
    }
}
