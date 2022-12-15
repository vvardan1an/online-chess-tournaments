package am.itspace.onlinechesstournamentrest.facade;

import am.itspace.onlinechesstournamentdatatransfer.request.UpdateWccRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.WccRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface AdminAccessOnly {

    ResponseEntity<?> deletePlayer(int id);

    ResponseEntity<?> deleteOrganizer(int id);

    ResponseEntity<?> createWorldChessChampion(WccRequest wccRequest, BindingResult bindingResult);

    ResponseEntity<?> updateWorldChessChampion(int id, UpdateWccRequest updateWccRequest, BindingResult bindingResult);

    ResponseEntity<?> deleteWorldChessChampion(int id);
}
