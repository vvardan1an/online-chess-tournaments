package am.itspace.onlinechesstournamentrest.facade.facadeImpl;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentcommon.entity.Admin;
import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.entity.Player;
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
import am.itspace.onlinechesstournamentrest.facade.LoginLogoutFacade;
import am.itspace.onlinechesstournamentrest.security.jwtAuth.JwtTokenUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class LoginLogoutFacadeImpl implements LoginLogoutFacade {

    private final OrganizerService organizerService;
    private final PlayerService playerService;
    private final AdminService adminService;
    private final OrganizerMapper organizerMapper;
    private final PlayerMapper playerMapper;
    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Organizer organizer = organizerService.findByEmail(email);
        Player player = playerService.findByEmail(email);
        Admin admin = adminService.findByEmail(email);

        if (organizer != null && passwordEncoder.matches(password, organizer.getPassword())) {
            return ResponseEntity.ok().body(OrganizerAuthResponse.builder()
                    .token(jwtTokenUtil.generateToken(email))
                    .organizer(organizerMapper.toResponse(organizer))
                    .build());
        }

        if (player != null && passwordEncoder.matches(password, player.getPassword())) {
            return ResponseEntity.ok().body(PlayerAuthResponse.builder()
                    .token(jwtTokenUtil.generateToken(email))
                    .player(playerMapper.toResponse(player))
                    .build());
        }

        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            return ResponseEntity.ok().body(AdminAuthResponse.builder()
                    .token(jwtTokenUtil.generateToken(email))
                    .admin(adminMapper.toResponse(admin))
                    .build());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @Override
    public ResponseEntity<?> logout(CurrentUser currentUser) {
        log.info("starting SecurityContextHolder cleanup process...");
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().body(currentUser.getUsername() + " has logged out.");
    }
}
