package am.itspace.onlinechesstournaments.service;

import am.itspace.onlinechesstournaments.entity.WorldChessChampion;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WorldChessChampionService {

    void add();

    void remove();

    WorldChessChampion edit();

    List<WorldChessChampion> findAll(Pageable pageable);

}
