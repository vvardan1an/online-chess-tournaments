package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
}
