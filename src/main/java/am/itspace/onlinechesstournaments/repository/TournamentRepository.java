package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}
