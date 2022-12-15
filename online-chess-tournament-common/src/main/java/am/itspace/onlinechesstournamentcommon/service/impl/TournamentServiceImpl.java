package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.Tournament;
import am.itspace.onlinechesstournamentcommon.repository.TournamentRepository;
import am.itspace.onlinechesstournamentcommon.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;

    @Override
    public Tournament save(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public boolean isPresent(int id) {
        return tournamentRepository.existsById(id);
    }

    @Override
    public void delete(Tournament tournament) {
        tournamentRepository.delete(tournament);
    }

    @Override
    public List<Tournament> findAll(Pageable pageable) {
        return tournamentRepository.findAll(pageable).getContent();
    }

    @Override
    public Tournament findById(int id) {
        return tournamentRepository.findById(id).get();
    }
}
