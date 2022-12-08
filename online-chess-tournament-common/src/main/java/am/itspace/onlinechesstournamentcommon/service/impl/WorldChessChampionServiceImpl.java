package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import am.itspace.onlinechesstournamentcommon.exception.WorldChessChampionNotFoundException;
import am.itspace.onlinechesstournamentcommon.mapper.WorldChessChampionMapper;
import am.itspace.onlinechesstournamentcommon.repository.WorldChessChampionRepository;
import am.itspace.onlinechesstournamentcommon.service.WorldChessChampionService;
import am.itspace.onlinechesstournamentcommon.util.IOUtil;
import am.itspace.onlinechesstournamentdatatransfer.request.UpdateWccRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorldChessChampionServiceImpl implements WorldChessChampionService {

    @Value("C:\\Users\\Hayk\\IdeaProjects\\online-chess-tournaments\\src\\main\\resources\\static\\worldChampionsPictures\\")
    private String wccPicturesPath;

    private final WorldChessChampionRepository wccRepository;

    private final WorldChessChampionMapper wccMapper;

    private final IOUtil ioUtil;

    public byte[] getPicture(String pngName) throws IOException {
        return ioUtil.getAllBytesByUrl(wccPicturesPath + pngName + ".png");
    }

    @Override
    public void deleteById(int id) {
        log.info("removing 'WorldChessChampion' by id: {}", id);
        wccRepository.deleteById(id);
    }

    @Override
    public WorldChessChampion update(UpdateWccRequest updateWccRequest, int id) {
        getById(id);
        WorldChessChampion wcc = wccMapper.toEntity(updateWccRequest);
        wcc.setId(id);
        return save(wcc);
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
    public int delete(int id) {
        getById(id);
        deleteById(id);
        return id;
    }
}
