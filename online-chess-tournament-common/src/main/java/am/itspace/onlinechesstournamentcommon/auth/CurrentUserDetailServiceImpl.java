package am.itspace.onlinechesstournamentcommon.auth;

import am.itspace.onlinechesstournamentcommon.entity.Admin;
import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.entity.UserType;
import am.itspace.onlinechesstournamentcommon.exception.UserNotFoundException;
import am.itspace.onlinechesstournamentcommon.service.AdminService;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrentUserDetailServiceImpl implements UserDetailsService {

    private final OrganizerService organizerService;

    private final PlayerService playerService;

    private final AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        boolean isCheckedRepository = false;

        String username = null;
        String password = null;
        UserType userType = null;

        try {
            log.info("starting search process for 'ORGANIZER' type user in organizer repository...");
            Organizer organizer = organizerService.findByEmail(email);
            username = organizer.getEmail();
            password = organizer.getPassword();
            userType = UserType.ORGANIZER;
        } catch (UserNotFoundException ex) {
            log.info("cannot find organizer with email '{}'", email);
            isCheckedRepository = true;
        }

        if (isCheckedRepository) {
            try {
                log.info("starting search process for 'PLAYER' type user in player repository...");
                Player player = playerService.findByEmail(email);
                username = player.getEmail();
                password = player.getPassword();
                userType = UserType.PLAYER;
                isCheckedRepository = false;
            } catch (UserNotFoundException ex) {
                log.info("cannot find player with username {}", username);
            }
        }

        if (isCheckedRepository) {
            try {
                log.info("starting search process for 'ADMIN' in admin repository...");
                Admin admin = adminService.findByEmail(email);
                username = admin.getEmail();
                password = admin.getPassword();
                userType = UserType.ADMIN;
            } catch (UserNotFoundException ex) {
                log.info("cannot find admin with username {}", username);
            }
        }

        if (password == null) {
            log.error("password is null");
            throw new BadCredentialsException("password cannot be null");
        }

        log.info("passing info into 'CurrentUser' constructor...");
        return new CurrentUser(username, password, userType);
    }
}
