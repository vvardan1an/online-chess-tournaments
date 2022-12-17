package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import am.itspace.onlinechesstournamentcommon.exception.WorldChessChampionNotFoundException;
import am.itspace.onlinechesstournamentcommon.repository.WorldChessChampionRepository;
import am.itspace.onlinechesstournamentcommon.service.WorldChessChampionService;
import am.itspace.onlinechesstournamentdatatransfer.request.updateRequest.UpdateWccRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorldChessChampionServiceImpl implements WorldChessChampionService {

    private final WorldChessChampionRepository wccRepository;

    @Override
    public void deleteById(int id) {
        wccRepository.deleteById(id);
    }

    @Override
    public WorldChessChampion update(UpdateWccRequest request, int id) {
        WorldChessChampion wccById = getById(id);
        return save(WorldChessChampion.builder()
                .id(id)
                .name(request.getName() == null ? wccById.getName() : request.getName())
                .surname(request.getSurname() == null ? wccById.getSurname() : request.getSurname())
                .birthDate(request.getBirthDate() == null ? wccById.getBirthDate() : request.getBirthDate())
                .died(request.getDied() == null ? wccById.getDied() : request.getDied())
                .cityCountry(request.getCityCountry() == null ? wccById.getCityCountry() : request.getCityCountry())
                .federation(request.getFederation() == null ? wccById.getFederation() : request.getFederation())
                .rating(request.getRating() == null ? wccById.getRating() : request.getRating())
                .peakRating(request.getPeakRating() == null ? wccById.getPeakRating() : request.getPeakRating())
                .worldChampionNumber(request.getWorldChampionNumber() == null ? wccById.getWorldChampionNumber() : request.getWorldChampionNumber())
                .quote(request.getQuote() == null ? wccById.getQuote() : request.getQuote())
                .info(request.getInfo() == null ? wccById.getInfo() : request.getInfo())
                .blitzRating(request.getBlitzRating() == null ? wccById.getBlitzRating() : request.getBlitzRating())
                .rapidRating(request.getRapidRating() == null ? wccById.getRapidRating() : request.getRapidRating())
                .title(request.getTitle() == null ? wccById.getTitle() : request.getTitle())
                .build());
    }


    @Override
    public List<WorldChessChampion> findAll(Pageable pageable) {
        log.info("request for list of 'WorldChessChampion' sorted by {}", pageable.getSort());
        return wccRepository.findAll(pageable).getContent();
    }

    @Override
    public WorldChessChampion getById(int id) {
        Optional<WorldChessChampion> optionalWCC = wccRepository.findById(id);
        if (optionalWCC.isEmpty()) {
            log.error("failed attempt to get a 'WorldChessChampion' by id: {}", id);
            throw new WorldChessChampionNotFoundException("Cannot find 'WorldChessChampion' by id: " + id);
        }
        log.info("'WorldChessChampion' by id: " + id + " was found");
        return optionalWCC.get();
    }

    @Override
    public WorldChessChampion save(WorldChessChampion wcc) {
        return wccRepository.save(wcc);
    }

    @Override
    public boolean existsById(int id) {
        return wccRepository.existsById(id);
    }
}
