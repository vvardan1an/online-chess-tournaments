package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Tournament;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TournamentService {

    Tournament save(Tournament tournament);

    boolean isPresent(int id);

    Tournament getById(int id);

    void delete(Tournament tournament);

    List<Tournament> findAll(Pageable pageable);

    Tournament findById(int id);
}
