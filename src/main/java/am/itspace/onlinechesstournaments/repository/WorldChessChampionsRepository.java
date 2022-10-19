package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.WorldChessChampions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorldChessChampionsRepository extends JpaRepository<WorldChessChampions, Integer> {
}
