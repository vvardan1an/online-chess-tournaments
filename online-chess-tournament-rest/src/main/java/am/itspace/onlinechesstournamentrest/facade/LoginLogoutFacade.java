package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentdatatransfer.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface LoginLogoutFacade {

    ResponseEntity<?> login(LoginRequest loginRequest);

    ResponseEntity<?> logout(CurrentUser currentUser);
}
