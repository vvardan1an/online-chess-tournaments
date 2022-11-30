package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.WorldChessChampion;
import am.itspace.onlinechesstournamentcommon.repository.WorldChessChampionRepository;
import am.itspace.onlinechesstournamentcommon.service.WorldChessChampionService;
import am.itspace.onlinechesstournamentcommon.util.IOUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorldChessChampionServiceImpl implements WorldChessChampionService {

    @Value("C:\\Users\\Hayk\\IdeaProjects\\online-chess-tournaments\\src\\main\\resources\\static\\worldChampionsPictures\\")
    private String wccPicturesPath;
    private final WorldChessChampionRepository worldChessChampionRepository;
    private final IOUtil ioUtil;

    public byte[] getPicture(String pngName) throws IOException {
        return ioUtil.getAllBytesByUrl(wccPicturesPath + pngName + ".png");
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public WorldChessChampion edit() {
        return null;
    }

    @Override
    public List<WorldChessChampion> findAll(Pageable pageable) {
        return worldChessChampionRepository.findAll(pageable).getContent();
    }
}
