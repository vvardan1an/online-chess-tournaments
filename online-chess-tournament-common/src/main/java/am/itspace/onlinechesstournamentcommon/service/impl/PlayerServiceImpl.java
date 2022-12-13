package am.itspace.onlinechesstournamentcommon.service.impl;

import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentcommon.mapper.PlayerMapper;
import am.itspace.onlinechesstournamentcommon.repository.PlayerRepository;
import am.itspace.onlinechesstournamentcommon.service.PlayerService;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final PlayerMapper playerMapper;

    @Override
    public Player findByEmail(String email) {
        log.info("attempt to get a 'Player' with email '{}'", email);
        return playerRepository.findByEmail(email);
    }

    @Override
    public Player save(PlayerRequest playerRequest) {
        Player player = playerMapper.toEntity(playerRequest);
        playerRepository.save(player);
        return player;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            playerRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            log.error("cannot delete player by id {}", id);
            return false;
        }
    }

    @Override
    public List<PlayerResponse> findAll() {
        return playerMapper.toResponseList(playerRepository.findAll());
    }
}