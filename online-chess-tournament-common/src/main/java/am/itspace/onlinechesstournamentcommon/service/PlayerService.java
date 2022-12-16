package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.PlayerResponse;

import java.util.List;

public interface PlayerService {

    Player findByEmail(String email);

    Player save(PlayerRequest playerRequest);

    boolean existsById(int id);

    List<PlayerResponse> findAll();

    void deleteById(int id);

    boolean existsByEmail(String email);
}
