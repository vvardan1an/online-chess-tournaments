package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Organizer;
import am.itspace.onlinechesstournamentdatatransfer.request.OrganizerRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.OrganizerResponse;

import java.util.List;

public interface OrganizerService {

    Organizer findByEmail(String email);

    Organizer save(OrganizerRequest organizerRequest);

    boolean existsById(int id);

    List<OrganizerResponse> findAll();

    void deleteById(int id);

    boolean existsByEmail(String email);
}
