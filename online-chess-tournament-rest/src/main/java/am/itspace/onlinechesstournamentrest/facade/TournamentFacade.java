package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentdatatransfer.request.TournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.UpdateTournamentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface TournamentFacade {

    ResponseEntity<?> createTournament(TournamentRequest tournamentRequest, CurrentUser currentUser, BindingResult br);

    ResponseEntity<?> update(UpdateTournamentRequest updateRequest, int id, CurrentUser currentUser, BindingResult br);

    ResponseEntity<?> delete(int id, CurrentUser currentUser);

    ResponseEntity<?> signUpForTournament(CurrentUser currentUser, int tournamentId);
}
