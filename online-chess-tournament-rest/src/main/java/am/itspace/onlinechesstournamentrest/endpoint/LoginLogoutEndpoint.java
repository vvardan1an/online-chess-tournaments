package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentdatatransfer.request.LoginRequest;
import am.itspace.onlinechesstournamentrest.facade.LoginLogoutFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LoginLogoutEndpoint {

    private final LoginLogoutFacade loginLogoutFacade;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/in")
    public ResponseEntity<?> auth(@RequestBody LoginRequest loginRequest) {
        return loginLogoutFacade.login(loginRequest);
    }

    @PreAuthorize("hasAnyAuthority('ORGANIZER', 'PLAYER', 'ADMIN')")
    @PostMapping("/out")
    public ResponseEntity<?> logout(@AuthenticationPrincipal CurrentUser currentUser) {
        return loginLogoutFacade.logout(currentUser);
    }
}