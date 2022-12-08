package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentcommon.entity.Player;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.PlayerRequest;

import java.util.Optional;

public interface OrganizerService {

    Organizer findByEmail(String email);

    Organizer save(OrganizerRequest organizerRequest);
}
