package am.itspace.onlinechesstournamentcommon.repository;

import am.itspace.onlinechesstournamentcommon.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByEmail(String email);

    boolean existsByEmail(String email);
}