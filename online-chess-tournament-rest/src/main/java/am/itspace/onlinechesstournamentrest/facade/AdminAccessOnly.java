package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentdatatransfer.request.creationRequest.WccRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.updateRequest.UpdateWccRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface AdminAccessOnly {

    /**
     * @param id player id
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> deletePlayer(int id);

    /**
     * @param id organizer id
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> deleteOrganizer(int id);

    /**
     * @param wccRequest    WorldChessChampion creation dto request
     * @param bindingResult binding result
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> createWorldChessChampion(WccRequest wccRequest, BindingResult bindingResult);

    /**
     * @param id               WorldChessChampion id
     * @param updateWccRequest update WorldChessChampion dto request;
     * @param bindingResult    binding result
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> updateWorldChessChampion(int id, UpdateWccRequest updateWccRequest, BindingResult bindingResult);

    /**
     * @param id WorldChessChampion id
     * @return ResponseEntity<?>
     */
    ResponseEntity<?> deleteWorldChessChampion(int id);
}
