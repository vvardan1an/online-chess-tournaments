package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.WorldChessChampion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldChessChampionRepository extends JpaRepository<WorldChessChampion, Integer> {
}
