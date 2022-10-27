package am.itspace.onlinechesstournaments.service;

import am.itspace.onlinechesstournaments.entity.WorldChessChampion;
import am.itspace.onlinechesstournaments.repository.WorldChessChampionRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorldChessChampionService {

    @Value("C:\\Users\\Hayk\\IdeaProjects\\online-chess-tournaments\\src\\main\\resources\\static\\worldChampionsPictures\\")
    private String wccPicturesPath;

    private final WorldChessChampionRepository wccRepository;

    public List<WorldChessChampion> findAll() {
        return wccRepository.findAllByOrderByWorldChampionNumberAsc();
    }

    public byte[] getPicture(String pngName) throws IOException {
        InputStream inputStream = new FileInputStream(wccPicturesPath + pngName + ".png");
        return IOUtils.toByteArray(inputStream);
    }
}
