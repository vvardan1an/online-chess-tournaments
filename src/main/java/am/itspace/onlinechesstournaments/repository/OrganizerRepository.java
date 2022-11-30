package am.itspace.onlinechesstournaments.repository;

import am.itspace.onlinechesstournaments.entity.Organizer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
}
