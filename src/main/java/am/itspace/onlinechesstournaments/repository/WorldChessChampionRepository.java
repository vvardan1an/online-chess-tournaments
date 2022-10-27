package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.WorldChessChampion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorldChessChampionRepository extends JpaRepository<WorldChessChampion, Integer> {

    List<WorldChessChampion> findAllByOrderByWorldChampionNumberAsc();
}
