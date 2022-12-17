package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentcommon.auth.CurrentUser;
import am.itspace.onlinechesstournamentdatatransfer.request.creationRequest.TournamentRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.updateRequest.UpdateTournamentRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface TournamentFacade {

    /**
     * @param tournamentRequest tournament creation dto request
     * @param currentUser       currentUser
     * @param br                binding result
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> createTournament(TournamentRequest tournamentRequest, CurrentUser currentUser, BindingResult br);

    /**
     * @param updateRequest update tournament dto request
     * @param id            tournament id which should be updated
     * @param currentUser   currentUser
     * @param br            binding result
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> update(UpdateTournamentRequest updateRequest, int id, CurrentUser currentUser, BindingResult br);

    /**
     * @param id          tournament id
     * @param currentUser currentUser
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> delete(int id, CurrentUser currentUser);

    /**
     * @param currentUser  currentUser
     * @param tournamentId tournament id
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> signUpForTournament(CurrentUser currentUser, int tournamentId);

    /**
     * @param id          tournament id
     * @param currentUser currentUser
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> withdraw(int id, CurrentUser currentUser);

    /**
     * @param id tournament id
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> getById(int id);

    /**
     * @param pageable pageable
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> getAll(Pageable pageable);
}
