package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentdatatransfer.request.loginRequest.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface LoginLogoutFacade {

    /**
     * @param loginRequest login dto request
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> login(LoginRequest loginRequest);

    /**
     * @param currentUser current user
     * @return ResponseEntity<?>
     * current user sends jwt token with request,
     * and gets cleared from SecurityContextHolder;
     */
    ResponseEntity<?> logout(CurrentUser currentUser);
}
