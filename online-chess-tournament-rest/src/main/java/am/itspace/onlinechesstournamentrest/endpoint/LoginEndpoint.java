package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.mapper.AdminMapper;
import am.itspace.onlinechesstournamentcommon.mapper.OrganizerMapper;
import am.itspace.onlinechesstournamentcommon.mapper.PlayerMapper;
import am.itspace.onlinechesstournamentcommon.service.AdminService;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.request.LoginRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.AdminAuthResponse;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerAuthResponse;
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

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginEndpoint {

    private final OrganizerService organizerService;
    private final PlayerService playerService;
    private final AdminService adminService;
    private final OrganizerMapper organizerMapper;
    private final PlayerMapper playerMapper;
    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        if (organizerService.findByEmail(email) != null &&
                passwordEncoder.matches(password, organizerService.findByEmail(email).getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(OrganizerAuthResponse.builder()
                    .token(jwtTokenUtil.generateToken(email))
                    .organizer(organizerMapper.toResponse(organizerService.findByEmail(email)))
                    .build());
        }

        if (playerService.findByEmail(email) != null &&
                passwordEncoder.matches(password, playerService.findByEmail(email).getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(PlayerAuthResponse.builder()
                    .token(jwtTokenUtil.generateToken(email))
                    .player(playerMapper.toResponse(playerService.findByEmail(email)))
                    .build());
        }

        if (adminService.findByEmail(email) != null &&
                passwordEncoder.matches(password, adminService.findByEmail(email).getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(AdminAuthResponse.builder()
                    .token(jwtTokenUtil.generateToken(email))
                    .admin(adminMapper.toResponse(adminService.findByEmail(email)))
                    .build());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
