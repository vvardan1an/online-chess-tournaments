package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

}
