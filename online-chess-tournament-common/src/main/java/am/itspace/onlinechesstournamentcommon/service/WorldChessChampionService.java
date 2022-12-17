package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import am.itspace.onlinechesstournamentdatatransfer.request.updateRequest.UpdateWccRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorldChessChampionService {

    void deleteById(int id);

    WorldChessChampion update(UpdateWccRequest updateWccRequest, int id);

    List<WorldChessChampion> findAll(Pageable pageable);

    WorldChessChampion getById(int id);

    WorldChessChampion save(WorldChessChampion wcc);

    boolean existsById(int id);
}
