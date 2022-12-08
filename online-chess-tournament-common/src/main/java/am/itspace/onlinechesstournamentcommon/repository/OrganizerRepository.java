package am.itspace.onlinechesstournamentcommon.repository;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {

    Organizer findByEmail(String email);
}
