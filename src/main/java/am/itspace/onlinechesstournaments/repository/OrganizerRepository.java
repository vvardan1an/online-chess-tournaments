package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {

    Optional<Organizer> findByEmail(String email);

    Optional<Organizer> findByNameOrSurname(String name,String surname);


    boolean findByNameOrSurname(boolean b);
}
