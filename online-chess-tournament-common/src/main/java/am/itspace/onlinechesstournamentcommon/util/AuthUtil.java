package am.itspace.onlinechesstournamentcommon.util;

import am.itspace.onlinechesstournamentcommon.service.AdminService;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthUtil {

    private final PlayerService playerService;

    private final AdminService adminService;

    private final OrganizerService organizerService;


    public boolean hasEmailConflict(String email) {
        return
                playerService.existsByEmail(email) ||
                        organizerService.existsByEmail(email) ||
                        adminService.existsByEmail(email);
    }
}
