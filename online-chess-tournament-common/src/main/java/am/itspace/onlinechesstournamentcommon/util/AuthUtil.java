package am.itspace.onlinechesstournamentcommon.util;

import am.itspace.onlinechesstournamentcommon.exception.UserNotFoundException;
import am.itspace.onlinechesstournamentcommon.service.OrganizerService;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthUtil {

    private final PlayerService playerService;

    private final OrganizerService organizerService;

    public boolean hasEmailConflict(String email) {
        return playerService.findByEmail(email) != null || organizerService.findByEmail(email) != null;
    }
}
