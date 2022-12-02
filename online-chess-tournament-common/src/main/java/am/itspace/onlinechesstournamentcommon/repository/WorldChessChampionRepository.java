package am.itspace.onlinechesstournamentcommon.repository;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldChessChampionRepository extends JpaRepository<WorldChessChampion, Integer> {
}
