package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorldChessChampionService {

    void add();

    void remove();

    WorldChessChampion edit();

    List<WorldChessChampion> findAll(Pageable pageable);

}
