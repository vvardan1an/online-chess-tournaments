package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

    Optional<Player> findByEmailAndPassword(String email, String password);

}
