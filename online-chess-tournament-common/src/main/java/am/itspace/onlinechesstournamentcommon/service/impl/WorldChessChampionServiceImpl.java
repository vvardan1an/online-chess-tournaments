package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import am.itspace.onlinechesstournamentcommon.exception.WorldChessChampionNotFoundException;
import am.itspace.onlinechesstournamentcommon.mapper.WorldChessChampionMapper;
import am.itspace.onlinechesstournamentcommon.repository.WorldChessChampionRepository;
import am.itspace.onlinechesstournamentcommon.service.WorldChessChampionService;
import am.itspace.onlinechesstournamentdatatransfer.request.UpdateWccRequest;
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

    private final WorldChessChampionMapper wccMapper;

    @Override
    public void deleteById(int id) {
        wccRepository.deleteById(id);
    }

    @Override
    public WorldChessChampion update(UpdateWccRequest updateWccRequest, int id) {
        WorldChessChampion wccById = getById(id);
        return save(WorldChessChampion.builder()
                .id(id)
                .name(updateWccRequest.getName() == null ? wccById.getName() : updateWccRequest.getName())
                .surname(updateWccRequest.getSurname() == null ? wccById.getSurname() : updateWccRequest.getSurname())
                .birthDate(updateWccRequest.getBirthDate() == null ? wccById.getBirthDate() : updateWccRequest.getBirthDate())
                .died(updateWccRequest.getDied() == null ? wccById.getDied() : updateWccRequest.getDied())
                .cityCountry(updateWccRequest.getCityCountry() == null ? wccById.getCityCountry() : updateWccRequest.getCityCountry())
                .federation(updateWccRequest.getFederation() == null ? wccById.getFederation() : updateWccRequest.getFederation())
                .rating(updateWccRequest.getRating() == null ? wccById.getRating() : updateWccRequest.getRating())
                .peakRating(updateWccRequest.getPeakRating() == null ? wccById.getPeakRating() : updateWccRequest.getPeakRating())
                .worldChampionNumber(updateWccRequest.getWorldChampionNumber() == null ? wccById.getWorldChampionNumber() : updateWccRequest.getWorldChampionNumber())
                .quote(updateWccRequest.getQuote() == null ? wccById.getQuote() : updateWccRequest.getQuote())
                .info(updateWccRequest.getInfo() == null ? wccById.getInfo() : updateWccRequest.getInfo())
                .blitzRating(updateWccRequest.getBlitzRating() == null ? wccById.getBlitzRating() : updateWccRequest.getBlitzRating())
                .rapidRating(updateWccRequest.getRapidRating() == null ? wccById.getRapidRating() : updateWccRequest.getRapidRating())
                .title(updateWccRequest.getTitle() == null ? wccById.getTitle() : updateWccRequest.getTitle())
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
        log.info("saving 'WorldChessChampion'...");
        return wccRepository.save(wcc);
    }

    @Override
    public boolean existsById(int id) {
        return wccRepository.existsById(id);
    }
}
