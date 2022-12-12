package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerResponse;

import java.util.List;
import java.util.Optional;

public interface OrganizerService {

    Organizer findByEmail(String email);

    Organizer save(OrganizerRequest organizerRequest);

    boolean deleteById(int id);

    List<OrganizerResponse> findAll();
}
